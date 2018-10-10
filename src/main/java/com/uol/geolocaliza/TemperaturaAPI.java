package com.uol.geolocaliza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.uol.entities.Temperatura;

public class TemperaturaAPI {
	
	private static LatLong latLong;
	private static Woeid[] woeid;	

	//Method to find whats the target latitude and longitude based on their IPV4 address
	private static void findLatLong() throws IOException {
		
		StringBuffer content = httpGetRequest("https://ipvigilante.com");
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode tree = mapper.readTree(content.toString());
		
		JsonNode node = tree.at("/data");
		latLong = mapper.treeToValue(node, LatLong.class);
	}
	
	//Metho to find based on the latitude and longitude to find which whats their Where On Earth ID (woeid) 
	private static String findWoeid() throws IOException {
		
		StringBuffer content = httpGetRequest("https://www.metaweather.com/api/location/search/?lattlong="+latLong.getLatitude()+","+latLong.getLongitude());
		
		String json = content.toString();
		ObjectMapper objectMapper = new ObjectMapper();
		
		//Set pretty printing of json
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    	
    	woeid = objectMapper.readValue(json, Woeid[].class);
    	return woeid[0].getWoeid();

	}
	
	//Execution of the methods above returning the woeid number
	private static String getWoeid() throws IOException {
		findLatLong();
		return findWoeid();
	}
	
	//Based on the woeid it gets the minimum and maximum temperature and return to the user
	public static Temperatura getMinMax() throws IOException {
		MinMaxTemp[] minMax;
		StringBuffer content = httpGetRequest("https://www.metaweather.com/api/location/"+getWoeid());
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode tree = objectMapper.readTree(content.toString());
		
		JsonNode node = tree.at("/consolidated_weather");
		String json = node.toString();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		minMax = objectMapper.readValue(json, MinMaxTemp[].class);
		Temperatura temp = new Temperatura();
		temp.setTempMin(Float.parseFloat(minMax[0].getMin_temp()));
		temp.setTempMax(Float.parseFloat(minMax[0].getMax_temp()));
		return temp;
	}
	
	//Basic method for a Get httpRequest
	private static StringBuffer httpGetRequest(String url) {
		StringBuffer content = null;
		try {			
			URL url2 = new URL(url);
			HttpURLConnection con = (HttpURLConnection) url2.openConnection();
			con.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
			
		} catch (Exception e) {
			return content.append(e.getMessage());
		}
		return content;
	}
	

}

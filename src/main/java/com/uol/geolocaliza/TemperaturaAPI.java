package com.uol.geolocaliza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TemperaturaAPI {
	
	private static LatLong latLong;
	private static ArrayWoeid woeid;
	
	private static void findLatLong() throws IOException {
		URL url2 = new URL("https://ipvigilante.com");
		HttpURLConnection con = (HttpURLConnection) url2.openConnection();
		con.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode tree = mapper.readTree(content.toString());
		
		JsonNode node = tree.at("/data");
		latLong = mapper.treeToValue(node, LatLong.class);
	}
	
	private static void findWoeid() throws IOException {
		URL url2 = new URL("https://www.metaweather.com/api/location/search/?lattlong="+latLong.getLatitude()+","+latLong.getLongitude());
		HttpURLConnection con = (HttpURLConnection) url2.openConnection();
		con.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();

		ObjectMapper mapper = new ObjectMapper();
		JsonNode tree = mapper.readTree(content.toString());
		
		JsonNode node = tree.at("");
		woeid=mapper.treeToValue(node, ArrayWoeid.class);
	}
	
	public static ArrayWoeid getWoeid() throws IOException {
		findLatLong();
		findWoeid();
		return woeid;
	}

}

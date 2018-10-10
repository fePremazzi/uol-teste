package com.uol.geolocaliza;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MinMaxTemp {
	
	@JsonProperty("min_temp")
	private String min_temp;

	@JsonProperty("max_temp")
	private String max_temp;

	public String getMin_temp() {
		return min_temp;
	}

	public void setMin_temp(String min_temp) {
		this.min_temp = min_temp;
	}

	public String getMax_temp() {
		return max_temp;
	}

	public void setMax_temp(String max_temp) {
		this.max_temp = max_temp;
	}

	public MinMaxTemp(String min_temp, String max_temp) {
		this.min_temp = min_temp;
		this.max_temp = max_temp;
	}

	public MinMaxTemp() {
	}
	
	

}

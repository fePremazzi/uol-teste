package com.uol.geolocaliza;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Woeid {
	
	@JsonProperty("woeid")
	private String woeid;
	
	public Woeid(String woeid) {
		super();
		this.woeid = woeid;
	}

	public String getWoeid() {
		return woeid;
	}

	public void setWoeid(String woeid) {
		this.woeid = woeid;
	}

	public Woeid() {
	}
	
	

}

package com.uol;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uol.geolocaliza.TemperaturaAPI;

//@SpringBootApplication
public class Application 
{
    public static void main( String[] args ) throws IOException
    {
        //SpringApplication.run(Application.class, args);
    	System.out.println(TemperaturaAPI.getWoeid());
    	
    }
}

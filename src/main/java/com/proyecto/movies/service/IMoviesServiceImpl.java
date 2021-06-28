package com.proyecto.movies.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.proyecto.movies.pojo.Movies;

@Service
public class IMoviesServiceImpl implements IMoviesService {
	
	@Override
	public Movies getMovies(String title, Integer page) {

		String uri = "https://jsonmock.hackerrank.com/api/movies/search/";

		StringBuilder urlWithParameters = new StringBuilder(uri);
		String firstParameter = "?Title="+title;
		String secondParameter = "&page="+page.toString();
		
		String completeUrl = urlWithParameters.append(firstParameter).append(secondParameter).toString();
		System.out.println(completeUrl);
		URL url = null;
		try {
			url = new URL(completeUrl);
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		HttpsURLConnection connection = null;
		try {
			connection = (HttpsURLConnection) url.openConnection();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		try {
			connection.setRequestMethod("GET");
		} catch (ProtocolException e) {
			
			e.printStackTrace();
		}
		connection.setRequestProperty("content-type", "application/json; charset=UTF-8");

		connection.setConnectTimeout(10000);
		try {
			connection.connect();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		BufferedReader br = null;
		try  {
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			br = new BufferedReader(isr);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

		Movies peliculas = new Gson().fromJson(sb.toString(), Movies.class);
		

		return peliculas;
	}

}

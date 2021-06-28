package com.proyecto.movies.service;

import com.proyecto.movies.pojo.Movies;

public interface IMoviesService {
	
	public Movies getMovies(String title, Integer page);

}

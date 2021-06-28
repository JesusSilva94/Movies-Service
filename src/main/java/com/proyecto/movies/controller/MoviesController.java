package com.proyecto.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyecto.movies.pojo.Movies;
import com.proyecto.movies.pojo.Parametros;
import com.proyecto.movies.service.IMoviesService;

@Controller
public class MoviesController {
	
	@Autowired
	IMoviesService moviesService;
	
	@RequestMapping(value = "/listar", method = RequestMethod.POST)
	public String getListMovies(Model model, @ModelAttribute Parametros parametros) {
		
		Movies movie = moviesService.getMovies(parametros.getTitle(), parametros.getPage());
		
		model.addAttribute("movie", movie);
		model.addAttribute("parametros", parametros);
		
		return "listar";
		
	}

	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public String index(Model model) {
		Parametros parametros = new Parametros();
		parametros.setPage(1);
	    model.addAttribute("parametros", parametros);
	    return "consultar";
	}
	
}

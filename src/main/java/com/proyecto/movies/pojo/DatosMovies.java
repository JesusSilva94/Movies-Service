package com.proyecto.movies.pojo;

public class DatosMovies {
	
	private String Title;
	private Integer Year;
	private String imdbID;
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		this.Title = title;
	}
	public Integer getYear() {
		return Year;
	}
	public void setYear(Integer year) {
		this.Year = year;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	@Override
	public String toString() {
		return "DatosMovies [Title=" + Title + ", Year=" + Year + ", imdbID=" + imdbID + "]";
	}
	
	
	
	}

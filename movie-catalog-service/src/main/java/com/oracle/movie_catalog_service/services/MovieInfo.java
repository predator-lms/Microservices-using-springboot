package com.oracle.movie_catalog_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.oracle.movie_catalog_service.models.CatalogItem;
import com.oracle.movie_catalog_service.models.Movie;
import com.oracle.movie_catalog_service.models.Rating;


@Service
public class MovieInfo {

	public MovieInfo() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
	public CatalogItem getCatalogItem(Rating rating) {
		Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/"+rating.getMovieId(), Movie.class);
		return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
	}
	
	public CatalogItem getFallbackCatalogItem(Rating rating) {
		return new CatalogItem("Movie name not found at this time.", "", rating.getRating());
	}
}

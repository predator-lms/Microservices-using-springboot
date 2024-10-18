package com.oracle.movie_info_service.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.oracle.movie_info_service.models.Movie;
import com.oracle.movie_info_service.models.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${api.key}")
	private String apiKey;
	
	
	@RequestMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId) {
		String URL = "https://api.themoviedb.org/3/movie/" + movieId + " ?api_key=" + apiKey + "&language=en-US";
		MovieSummary movieSummary = restTemplate.getForObject(URL, MovieSummary.class);
		
		return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
	}
}

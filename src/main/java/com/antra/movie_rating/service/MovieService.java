package com.antra.movie_rating.service;

import com.antra.movie_rating.api.request.MovieCriteria;
import com.antra.movie_rating.domain.Movie;

import java.util.List;

public interface MovieService {

	public Movie searchMovie(MovieCriteria criteria);

	public List<Movie> searchMovie(String type);
}

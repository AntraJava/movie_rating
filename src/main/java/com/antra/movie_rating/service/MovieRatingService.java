package com.antra.movie_rating.service;

import com.antra.movie_rating.domain.MovieCharact;
import com.antra.movie_rating.domain.MovieScore;

import java.util.List;

public interface MovieRatingService {
	List<MovieCharact> getAllMovieCharact();

	String saveRating(List<MovieScore> score);
}

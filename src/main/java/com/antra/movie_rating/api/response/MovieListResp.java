package com.antra.movie_rating.api.response;

import java.util.List;

public class MovieListResp {
	private List<MovieVO> movies;

	public List<MovieVO> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieVO> movies) {
		this.movies = movies;
	}
}

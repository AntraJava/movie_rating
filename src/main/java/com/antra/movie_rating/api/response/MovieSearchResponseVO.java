package com.antra.movie_rating.api.response;

import com.antra.movie_rating.domain.Movie;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MovieSearchResponseVO {
	@JsonProperty("Search")
	private List<Movie> movies;
	private int totalResults;

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public int getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	@Override
	public String toString() {
		return "MovieSearchResponseVO{" +
				"movies=" + movies +
				", totalResults=" + totalResults +
				'}';
	}
}

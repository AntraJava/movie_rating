package com.antra.movie_rating.api.response;

import com.antra.movie_rating.domain.Movie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class MovieVO {

	@JsonIgnore
	private Movie movie;

	public MovieVO(Movie movie) {
		this.movie = movie;
	}
	@JsonProperty
	public String getTitle() {
		return movie.getTitle();
	}
	@JsonProperty
	public String getYear() {
		return movie.getYear();
	}
	@JsonProperty
	public String getRelease() {
		return movie.getRelease();
	}
	@JsonProperty
	public String getRuntime() {
		return movie.getRuntime();
	}
	@JsonProperty
	public String getGenre() {
		return movie.getGenre();
	}
	@JsonProperty
	public String getDirector() {
		return movie.getDirector();
	}
	@JsonProperty
	public String getPlot() {
		return movie.getPlot();
	}
	@JsonProperty
	public String getPoster() {
		return movie.getPoster();
	}

	@JsonProperty
	public String getImdbId() {
		return movie.getImdbId();
	}
	@JsonProperty
	public Integer getId() {
		return movie.getId();
	}

	@JsonProperty
	@Setter
	@Getter
	private int averageRate;

}


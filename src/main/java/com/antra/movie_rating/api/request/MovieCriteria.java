package com.antra.movie_rating.api.request;

public class MovieCriteria {
	private String title;
	private String type;

	public MovieCriteria(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}

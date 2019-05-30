package com.antra.movie_rating.exception;

public class MovieNotExistExeption extends RuntimeException {
	public MovieNotExistExeption() {
	}

	public MovieNotExistExeption(String message) {
		super(message);
	}
}

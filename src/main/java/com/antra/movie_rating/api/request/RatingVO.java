package com.antra.movie_rating.api.request;

import lombok.Data;

import java.util.Map;

@Data
public class RatingVO {
	private String comment;
	private Integer movieId;
	private Map<Integer, Integer> rateStars;
}

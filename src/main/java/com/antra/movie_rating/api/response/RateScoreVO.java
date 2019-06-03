package com.antra.movie_rating.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RateScoreVO {
	private String category;
	private Integer score;
}

package com.antra.movie_rating.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RatingCommentResponseVO {
	private int movieId;
	private String username;
	private Map<String, Integer> detailScore;
	private String comment;
	private Date timeStamp;
}

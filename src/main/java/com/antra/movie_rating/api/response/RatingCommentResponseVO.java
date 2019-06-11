package com.antra.movie_rating.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RatingCommentResponseVO {
	private int movieId;
	private String movieTitle;
	private String username;
	private List<RateScoreVO> detailScore;
	private String comment;
	private Date timeStamp;
}

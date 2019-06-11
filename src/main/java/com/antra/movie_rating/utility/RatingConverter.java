package com.antra.movie_rating.utility;

import com.antra.movie_rating.api.response.RateScoreVO;
import com.antra.movie_rating.api.response.RatingCommentResponseVO;
import com.antra.movie_rating.domain.MovieRating;
import com.antra.movie_rating.domain.MovieScore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RatingConverter {
	public static List<RatingCommentResponseVO> convertRatingListToResponseVO(List<MovieRating> ratingList) {
		return ratingList.stream().map(rating -> {
			RatingCommentResponseVO vo = new RatingCommentResponseVO();
			vo.setMovieId(rating.getMovie().getId());
			vo.setMovieTitle(rating.getMovie().getTitle());
			vo.setComment(rating.getComment());
			vo.setUsername(rating.getUser().getName());
			vo.setTimeStamp(rating.getCreatedDate());
			List<RateScoreVO> detail = new ArrayList<>();
			for (MovieScore score : rating.getScores()) {
				detail.add(new RateScoreVO(score.getCharact().getName(), score.getScore()));
			}
			vo.setDetailScore(detail);
			return vo;
		}).collect(Collectors.toList());
	}
}

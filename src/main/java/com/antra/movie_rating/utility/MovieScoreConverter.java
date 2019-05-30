package com.antra.movie_rating.utility;

import com.antra.movie_rating.api.request.RatingVO;
import com.antra.movie_rating.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MovieScoreConverter {
	public static MovieRating convertRatingVOtoMovieRating(RatingVO vo, Long userId) {
		MovieRating rating = new MovieRating();
		List<MovieScore> scores = new ArrayList<>();
		for(Map.Entry<Integer, Integer> rate : vo.getRateStars().entrySet()) {
			MovieScore score = new MovieScore();
			score.setCharact(MovieCharact.builder().id(rate.getKey()).build());
			score.setScore(rate.getValue());
			score.setRating(rating);
			scores.add(score);
		}
		rating.setScores(scores);
		rating.setComment(vo.getComment());
		rating.setUser(new User(userId.intValue()));
		rating.setMovie(Movie.builder().id(vo.getMovieId()).build());
		return rating;
	}
}

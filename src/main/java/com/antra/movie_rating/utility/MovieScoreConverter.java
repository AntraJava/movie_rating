package com.antra.movie_rating.utility;

import com.antra.movie_rating.api.request.RatingVO;
import com.antra.movie_rating.domain.Movie;
import com.antra.movie_rating.domain.MovieCharact;
import com.antra.movie_rating.domain.MovieScore;
import com.antra.movie_rating.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MovieScoreConverter {
	public static List<MovieScore> convertRatingVOtoMovieScore(RatingVO vo, Integer userId) {
		List<MovieScore> scores = new ArrayList<>();
		String txId = UUID.randomUUID().toString();
		for(Map.Entry<Integer, Integer> rate : vo.getRateStars().entrySet()) {
			MovieScore score = new MovieScore();
			score.setMovie(Movie.builder().id(vo.getMovieId()).build());
			score.setUser(new User(userId));
			score.setCharact(MovieCharact.builder().id(rate.getKey()).build());
			score.setScore(rate.getValue());
			score.setTransactionId(txId);
			scores.add(score);
		}
		return scores;
	}
}

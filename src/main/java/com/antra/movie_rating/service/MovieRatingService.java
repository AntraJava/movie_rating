package com.antra.movie_rating.service;

import com.antra.movie_rating.api.response.RatingCommentResponseVO;
import com.antra.movie_rating.domain.MovieCharact;
import com.antra.movie_rating.domain.MovieRating;
import com.antra.movie_rating.domain.MovieScore;

import java.util.Date;
import java.util.List;

public interface MovieRatingService {
	List<MovieCharact> getAllMovieCharact();

	MovieRating saveRating(MovieRating rating);

	Float getAverageScore(int movieId);

	boolean getIfUserCanRateMovie(int movieId, int userId);

	List<RatingCommentResponseVO> getRatingCommentInfo(int movieId, int page, int recordNo, Date fromTime);

	List<RatingCommentResponseVO> getRatingByUserId(int userId, int recordNo, int page);
}

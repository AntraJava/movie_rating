package com.antra.movie_rating.dao;

import com.antra.movie_rating.domain.MovieAverageScore;

public interface MovieAverageScoreCustomRepo {
	MovieAverageScore updateAverage(Integer id);
}

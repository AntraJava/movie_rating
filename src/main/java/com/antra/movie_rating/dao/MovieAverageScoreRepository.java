package com.antra.movie_rating.dao;

import com.antra.movie_rating.domain.MovieAverageScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MovieAverageScoreRepository extends JpaRepository<MovieAverageScore, Integer>, MovieAverageScoreCustomRepo {
	MovieAverageScore findByMovieId(Integer id);
}

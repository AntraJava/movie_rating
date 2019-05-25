package com.antra.movie_rating.dao;

import com.antra.movie_rating.domain.MovieScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRatingDAO extends JpaRepository<MovieScore, Integer> {

}

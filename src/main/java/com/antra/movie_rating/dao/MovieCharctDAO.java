package com.antra.movie_rating.dao;


import com.antra.movie_rating.domain.MovieCharact;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieCharctDAO extends JpaRepository<MovieCharact, Integer> {

}

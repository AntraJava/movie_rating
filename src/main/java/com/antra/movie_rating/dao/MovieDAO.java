package com.antra.movie_rating.dao;


import com.antra.movie_rating.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieDAO extends JpaRepository<Movie, Integer> {

	List<Movie> findByTitleIgnoreCase(String title);

	Movie findByImdbIdIgnoreCase(String imdbId);
}

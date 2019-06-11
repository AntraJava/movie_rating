package com.antra.movie_rating.dao;

import com.antra.movie_rating.domain.MovieRating;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface MovieRatingDAO extends JpaRepository<MovieRating, Integer> {
	List<MovieRating> findByUserIdAndMovieId(int movieId, int userId);

	List<MovieRating> findByCreatedDateBeforeAndMovieId(Date fromTime, int movieId, Pageable pageable);

	List<MovieRating> findByUserIdOrderByCreatedDateDesc(int userId, Pageable pageCriteria);
}

package com.antra.movie_rating.dao.impl;

import com.antra.movie_rating.dao.MovieAverageScoreCustomRepo;
import com.antra.movie_rating.dao.MovieAverageScoreRepository;
import com.antra.movie_rating.dao.MovieDAO;
import com.antra.movie_rating.domain.Movie;
import com.antra.movie_rating.domain.MovieAverageScore;
import com.antra.movie_rating.exception.MovieNotExistExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

public class MovieAverageScoreRepositoryImpl implements MovieAverageScoreCustomRepo {

	@Autowired
	MovieAverageScoreRepository movieAverageScoreRepository;
	@Autowired
	MovieDAO movieDAO;

	@Autowired
	EntityManager em;

	@Override
	public MovieAverageScore updateAverage(Integer id) {

		Optional<Movie> movieOptional = movieDAO.findById(id);
		if(!movieOptional.isPresent()){
			throw new MovieNotExistExeption("Cannot find movie with ID : " + id);
		};


		MovieAverageScore score = movieAverageScoreRepository.findByMovieId(id);

		Query query = em.createNativeQuery("select avg(score) from movie_score s join movie_rating r on r.id = s.movie_rating_id where r.movie_id = :mId");
		query.setParameter("mId", id);
		BigDecimal avgScore = (BigDecimal)query.getSingleResult();
		avgScore.setScale(2, RoundingMode.CEILING);
		if (score != null) {
			score.setAverageScore(avgScore.floatValue());
		} else{
			score = (MovieAverageScore.builder().averageScore(avgScore.floatValue()).movie(movieOptional.get()).build());
		}
		score = movieAverageScoreRepository.save(score);
		return score;
	}

}

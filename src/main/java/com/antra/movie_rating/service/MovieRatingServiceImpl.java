package com.antra.movie_rating.service;

import com.antra.movie_rating.dao.MovieCharctDAO;
import com.antra.movie_rating.dao.MovieRatingDAO;
import com.antra.movie_rating.domain.MovieCharact;
import com.antra.movie_rating.domain.MovieScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieRatingServiceImpl implements MovieRatingService {
	@Autowired
	MovieCharctDAO charctDAO;
	@Autowired
	MovieRatingDAO ratingDAO;

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value="charactCache")
	public List<MovieCharact> getAllMovieCharact() {
		return charctDAO.findAll();
	}

	@Override
	@Transactional
	public String saveRating(List<MovieScore> score) {
		List<MovieScore> saved = ratingDAO.saveAll(score);
		return score.get(0).getTransactionId();
	}


}

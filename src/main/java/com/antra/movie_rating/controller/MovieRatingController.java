package com.antra.movie_rating.controller;

import com.antra.movie_rating.api.request.MovieCriteria;
import com.antra.movie_rating.api.request.RatingVO;
import com.antra.movie_rating.api.response.MovieListResp;
import com.antra.movie_rating.api.response.MovieVO;
import com.antra.movie_rating.api.response.RatingResponseVO;
import com.antra.movie_rating.domain.Movie;
import com.antra.movie_rating.domain.MovieCharact;
import com.antra.movie_rating.exception.MovieNotExistExeption;
import com.antra.movie_rating.service.MovieRatingService;
import com.antra.movie_rating.service.MovieService;
import com.antra.movie_rating.utility.MovieScoreConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@Slf4j
public class MovieRatingController {

	@Autowired
	MovieService movieService;

	@Autowired
	MovieRatingService ratingService;

	@GetMapping("/movie/characteristics")
	public List<MovieCharact> getMovieTypes(){
		return ratingService.getAllMovieCharact();
	}

	@PostMapping("/movie")
	public ResponseEntity<Object> rateMovie(@RequestBody RatingVO rate) {
		log.info(rate.toString());
		ratingService.saveRating(MovieScoreConverter.convertRatingVOtoMovieScore(rate,1));
		return new ResponseEntity<Object>(new RatingResponseVO("hello"), HttpStatus.OK);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void noMovieFound(MovieNotExistExeption ex) {

	}
}

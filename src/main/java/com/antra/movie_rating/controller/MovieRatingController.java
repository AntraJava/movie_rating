package com.antra.movie_rating.controller;

import com.antra.movie_rating.api.request.MovieCriteria;
import com.antra.movie_rating.api.request.RatingVO;
import com.antra.movie_rating.api.response.MovieListResp;
import com.antra.movie_rating.api.response.MovieVO;
import com.antra.movie_rating.api.response.RatingCommentResponseVO;
import com.antra.movie_rating.api.response.RatingResponseVO;
import com.antra.movie_rating.config.security.LoginUser;
import com.antra.movie_rating.config.security.UserPrincipal;
import com.antra.movie_rating.domain.Movie;
import com.antra.movie_rating.domain.MovieCharact;
import com.antra.movie_rating.domain.MovieRating;
import com.antra.movie_rating.exception.MovieNotExistExeption;
import com.antra.movie_rating.service.MovieRatingService;
import com.antra.movie_rating.service.MovieService;
import com.antra.movie_rating.utility.MovieScoreConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@Slf4j
@Secured({"ROLE_USER", "ROLE_ADMIN"})
@RequestMapping("/movie")
public class MovieRatingController {

	@Autowired
	MovieService movieService;

	@Autowired
	MovieRatingService ratingService;

	@GetMapping("/characteristics")
	public List<MovieCharact> getMovieTypes(){
		return ratingService.getAllMovieCharact();
	}

	@GetMapping("/average")
	public ResponseEntity<RatingResponseVO>  getMovieAverage(@RequestParam int movieId){
		Float result = ratingService.getAverageScore(movieId);
		return new ResponseEntity<RatingResponseVO>(RatingResponseVO.builder()
				.rating(result)
				.movieId(movieId)
				.build(), HttpStatus.OK);
	}

	@GetMapping("/rateStatus")
	public ResponseEntity<RatingResponseVO>  getMovieRateStatus(@RequestParam int movieId, @LoginUser UserPrincipal user){
		boolean canRate = ratingService.getIfUserCanRateMovie(movieId, user.getId().intValue());
		Float avgScore = ratingService.getAverageScore(movieId);
		return new ResponseEntity<RatingResponseVO>(RatingResponseVO.builder()
				.movieId(movieId)
				.userId(user.getId().intValue())
				.enableRate(canRate)
				.rating(avgScore)
				.build(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> rateMovie(@RequestBody RatingVO rate,@LoginUser UserPrincipal user) {
		log.info(rate.toString());
		MovieRating result = ratingService.saveRating(MovieScoreConverter.convertRatingVOtoMovieRating(rate,user.getId()));
		return new ResponseEntity<Object>(RatingResponseVO.builder().msg("Rating is saved.")
				.movieId(result.getMovie().getId())
				.build(), HttpStatus.OK);
	}

	@GetMapping("/ratingInfo")
	public ResponseEntity<Object>  getMovieRatingInfo(@RequestParam int movieId,
	                                                  @RequestParam int page,
	                                                  @RequestParam int recordNo,
	                                                  @RequestParam
	                                                      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
			                                                      Date fromTime){
		List<RatingCommentResponseVO> result= ratingService.getRatingCommentInfo(movieId, page, recordNo, fromTime);
		log.info("MovieId {} Page {} RecordNo {} FromTimeISO {}", movieId, page, recordNo,fromTime );
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}

	@GetMapping("/ratingByUser")
	public ResponseEntity<Object>  getMovieRatingByUserId(@RequestParam int page, @RequestParam int recordNo, @RequestParam int userId){
		List<RatingCommentResponseVO> result= ratingService.getRatingByUserId(userId, recordNo, page);
		log.info("UserId {} Page {}", userId, page);
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void noMovieFound(MovieNotExistExeption ex) {

	}
}

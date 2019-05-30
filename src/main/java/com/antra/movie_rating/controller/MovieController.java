package com.antra.movie_rating.controller;

import com.antra.movie_rating.api.request.MovieCriteria;
import com.antra.movie_rating.api.response.MovieListResp;
import com.antra.movie_rating.api.response.MovieVO;
import com.antra.movie_rating.config.security.LoginUser;
import com.antra.movie_rating.config.security.UserPrincipal;
import com.antra.movie_rating.domain.Movie;
import com.antra.movie_rating.exception.MovieNotExistExeption;
import com.antra.movie_rating.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@Secured({"ROLE_USER", "ROLE_ADMIN"})
public class MovieController {

	@Autowired
	MovieService movieService;

	@GetMapping("/movie")
	public MovieListResp getMovie(@RequestParam String title, @LoginUser UserPrincipal user){
		Movie movie = movieService.searchMovie(new MovieCriteria(title));
		if (StringUtils.isEmpty(movie.getTitle())) {
			throw new MovieNotExistExeption();
		}
		MovieListResp resp = new MovieListResp();
		resp.setMovies(Arrays.asList(new MovieVO(movie)));
		return resp;
	}

	@GetMapping("/movie/popular")
	public MovieListResp getMovieTypes(@RequestParam String type){
		List<Movie> movies = movieService.searchMovie(type);
		if (movies.size() < 1) {
			throw new MovieNotExistExeption();
		}
		MovieListResp resp = new MovieListResp();
		resp.setMovies(movies.stream().map(m->new MovieVO(m)).collect(Collectors.toList()));
		return resp;
	}

	@GetMapping("/movieDetail")
	public MovieVO getMovieDetail(@RequestParam String title){
		Movie movie = movieService.searchMovie(new MovieCriteria(title));
		if (StringUtils.isEmpty(movie.getTitle())) {
			throw new MovieNotExistExeption();
		}
		return new MovieVO(movie);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void noMovieFound(MovieNotExistExeption ex) {

	}
}

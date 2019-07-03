package com.antra.movie_rating.service.feign;

import com.antra.movie_rating.api.response.MovieSearchResponseVO;
import com.antra.movie_rating.domain.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "OmdbServer", url = "http://www.omdbapi.com")
public interface OmdbClient {

	@GetMapping
	Movie getMovieByTitle(@SpringQueryMap Map<String, String> params);

	@GetMapping
	MovieSearchResponseVO getMovieBySearch(@SpringQueryMap Map<String, String> params);
}


//	String url = "http://www.omdbapi.com";
//	RestTemplate rt = new RestTemplate();
//
//	UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
//			.queryParam("apikey", "27c4caaf")
//			.queryParam("t", criteria.getTitle())
//			.queryParam("plot", "full");
//
//	RequestEntity<Void> request = RequestEntity
//			.get(uriBuilder.build().toUri()).accept(MediaType.APPLICATION_JSON).build();
//	ResponseEntity<Movie> movie = rt.exchange(request, Movie.class);

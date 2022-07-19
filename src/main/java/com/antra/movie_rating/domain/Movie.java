package com.antra.movie_rating.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * This class is used for both Database Mapping and Remote API call to OMDB api. I don't like this
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonProperty("imdbID")
	private String imdbId;
	@JsonProperty("Title")
	private String title;
	@JsonProperty("Year")
	@Column(name="year")
	private String year;
	@JsonProperty("Released")
	@Column(name="release")
	private String release;
	@JsonProperty("Runtime")
	private String runtime;
	@JsonProperty("Genre")
	private String genre;
	@JsonProperty("Director")
	private String director;
	@JsonProperty("Poster")
	@Column(length = 2000)
	private String poster;
	@JsonProperty("Plot")
	@Column(length = 4000)
	private String plot;

	@OneToMany
	@JsonIgnore
	private List<MovieRating> rating;


}
//"Title": "Harry Potter and the Deathly Hallows: Part 2",
//		"Year": "2011",
//		"Rated": "PG-13",
//		"Released": "15 Jul 2011",
//		"Runtime": "130 min",
//		"Genre": "Adventure, Drama, Fantasy, Mystery",
//		"Director": "David Yates",
//		"Writer": "Steve Kloves (screenplay), J.K. Rowling (novel)",
//		"Actors": "Ralph Fiennes, Michael Gambon, Alan Rickman, Daniel Radcliffe",
//		"Plot": "Harry, Ron, and Hermione search for Voldemort's remaining Horcruxes in their effort to destroy the Dark Lord as the final battle rages on at Hogwarts.",
//		"Language": "English",
//		"Country": "USA, UK",
//		"Awards": "Nominated for 3 Oscars. Another 45 wins & 91 nominations.",
//		"Poster": "https://m.media-amazon.com/images/M/MV5BMjIyZGU4YzUtNDkzYi00ZDRhLTljYzctYTMxMDQ4M2E0Y2YxXkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_SX300.jpg",
//		"Ratings": [
//		{
//		"Source": "Internet Movie Database",
//		"Value": "8.1/10"
//		},
//		{
//		"Source": "Rotten Tomatoes",
//		"Value": "96%"
//		},
//		{
//		"Source": "Metacritic",
//		"Value": "87/100"
//		}
//		],
//		"Metascore": "87",
//		"imdbRating": "8.1",
//		"imdbVotes": "685,241",
//		"imdbID": "tt1201607",
//		"Type": "movie",
//		"DVD": "11 Nov 2011",
//		"BoxOffice": "$381,000,185",
//		"Production": "Warner Bros. Pictures",
//		"Website": "http://www.HarryPotter.com/",
//		"Response": "True"

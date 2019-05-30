package com.antra.movie_rating.domain;

import lombok.Data;

import javax.persistence.*;

@Entity(name="movie_score")
@Data
public class MovieScore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="movie_char_id")
	private MovieCharact charact;

	@Column(name="score")
	private Integer score;

	@ManyToOne
	@JoinColumn(name="movie_rating_id")
	private MovieRating rating;
}

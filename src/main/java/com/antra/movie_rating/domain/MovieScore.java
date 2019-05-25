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
	@JoinColumn(name="user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name="movie_id")
	private Movie movie;

	@ManyToOne
	@JoinColumn(name="movie_char_id")
	private MovieCharact charact;

	@Column(name="score")
	private Integer score;

	@Column(name = "tx_id")
	private String transactionId;
}

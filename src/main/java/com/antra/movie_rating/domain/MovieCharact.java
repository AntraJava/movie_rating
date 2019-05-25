package com.antra.movie_rating.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie_characteristics")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieCharact {
	@Id
	private Integer id;
	private String name;


}

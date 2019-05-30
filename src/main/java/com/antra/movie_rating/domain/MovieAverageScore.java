package com.antra.movie_rating.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity(name="movie_average")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class MovieAverageScore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="movie_id")
	private Movie movie;

	@Column(name = "updated_date")
	@LastModifiedDate
	private Date updateDate;

	@Column(name="average_score")
	private float averageScore;

	@Override
	public String toString() {
		return "MovieAverageScore{" +
				"id=" + id +
				", movie=" + movie.getId() +
				", updateDate=" + updateDate +
				", average Score=" + averageScore +
				'}';
	}
}

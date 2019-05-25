package com.antra.movie_rating.domain;

import lombok.Data;

import javax.persistence.*;

@Entity(name="user_role")
@Data
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	@Enumerated(EnumType.STRING)
	private RoleName name;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

}

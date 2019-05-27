package com.antra.movie_rating.domain;

import lombok.Data;

import javax.persistence.*;

@Entity(name="user_role")
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

	public UserRole() {
	}

	public UserRole(RoleName name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RoleName getName() {
		return name;
	}

	public void setName(RoleName name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UserRole userRole = (UserRole) o;

		return name == userRole.name;

	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}

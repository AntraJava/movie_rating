package com.antra.movie_rating.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="name")
	private String name;

	private String username;

	private String email;

	private String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	Set<UserRole> roles;

	public User() {
	}

	public User(Integer id) {
		this.id = id;
	}
	public User(String name, String username, String email, String password, Set<UserRole> roles) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (!name.equals(user.name)) return false;
		if (!username.equals(user.username)) return false;
		if (!email.equals(user.email)) return false;
		return password.equals(user.password);

	}

	@Override
	public int hashCode() {
		int result = username.hashCode();
		result = 31 * result + email.hashCode();
		result = 31 * result + password.hashCode();
		return result;
	}
}

package com.antra.movie_rating.service;

import com.antra.movie_rating.domain.User;

import java.util.List;
import java.util.Optional;

public interface AdminUserService {
	List<User> getAllUsers(int page);

	Optional<User> getUserById(int userId);
}

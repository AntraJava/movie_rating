package com.antra.movie_rating.service;

import com.antra.movie_rating.dao.UserRepository;
import com.antra.movie_rating.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminUserServiceImpl implements AdminUserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers(int page) {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(int userId) {
		return userRepository.findById(userId);
	}
}

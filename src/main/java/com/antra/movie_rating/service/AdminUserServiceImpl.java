package com.antra.movie_rating.service;

import com.antra.movie_rating.dao.UserRepository;
import com.antra.movie_rating.dao.UserRoleRepository;
import com.antra.movie_rating.domain.RoleName;
import com.antra.movie_rating.domain.User;
import com.antra.movie_rating.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AdminUserServiceImpl implements AdminUserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	UserRoleRepository roleRepository;

	@Override
	@Transactional(readOnly = true)
	public List<User> getAllUsers(int page) {
		return userRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> getUserById(int userId) {
		return userRepository.findById(userId);
	}

	@Override
	@Transactional
	public Boolean addAdminRole(int id) {
		UserRole newRole = new UserRole(RoleName.ROLE_ADMIN);
		newRole.setUser(new User(id));
		return roleRepository.save(newRole) != null;
	}

	@Override
	@Transactional
	public int removeAdminRole(int id) {
		return roleRepository.deleteByRoleAndUserId(RoleName.ROLE_ADMIN.name(), id);
	}
}

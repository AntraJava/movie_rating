package com.antra.movie_rating.controller;

import com.antra.movie_rating.api.response.UserListAdminResponse;
import com.antra.movie_rating.api.response.UserVO;
import com.antra.movie_rating.domain.User;
import com.antra.movie_rating.service.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@Secured({"ROLE_ADMIN"})
@Slf4j
@RequestMapping("/users")
public class AdminController {
	@Autowired
	AdminUserService userService;

	@GetMapping
	public UserListAdminResponse getAllUsers(@RequestParam int page){
		List<User> userList = userService.getAllUsers(page);
		UserListAdminResponse response = new UserListAdminResponse();
		response.setPage(page);
		response.setSize(userList.size());
		response.setUsers(userList.stream().map(entity -> UserVO.builder()
				.id(entity.getId())
				.name(entity.getName())
				.username(entity.getUsername())
				.email(entity.getEmail())
				.role(entity.getRoles().stream().map(role -> role.getName().toString()).collect(Collectors.toList()))
				.build()
		).collect(Collectors.toList()));
		return response;
	}

	@GetMapping("/{id}")
	public UserVO getUserById(@PathVariable int id){
		Optional<User> entity = userService.getUserById(id);
		User user = entity.get();
		return UserVO.builder()
				.id(user.getId())
				.name(user.getName())
				.username(user.getUsername())
				.email(user.getEmail())
				.role(user.getRoles().stream().map(role -> role.getName().toString()).collect(Collectors.toList()))
				.build();
	}
}

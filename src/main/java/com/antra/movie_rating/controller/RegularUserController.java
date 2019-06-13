package com.antra.movie_rating.controller;

import com.antra.movie_rating.api.response.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@Secured({"ROLE_USER","ROLE_ADMIN"})
@Slf4j
@RequestMapping("/users")
public class RegularUserController {

	@PostMapping
	public UserVO updateUser(@RequestBody UserVO userVO) {
		log.debug(userVO.toString());
		return userVO;
	}
}

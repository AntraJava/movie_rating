package com.antra.movie_rating.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {
	private Integer id;
	private String name;
	private String username;
	private String email;
	private String password;
	private List<String> role;

}

package com.antra.movie_rating;

import com.antra.movie_rating.dao.UserRepository;
import com.antra.movie_rating.dao.UserRoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
//
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MovieRatingApplicationTests {

	@Autowired
	UserRoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	//@Test
	public void contextLoads() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("1234"));
	}
//	@Test
//	@Transactional
	public void testRoleDAO() {
		System.out.println(roleRepository.findAll().size());
	}

	@Test
	@Transactional
	public void testUserDAO() {
//		System.out.println(userRepository.existsByEmail("123@gmail.com"));
		System.out.println(userRepository.findByUsernameOrEmail("","123@gmail.com").get());
	}

}

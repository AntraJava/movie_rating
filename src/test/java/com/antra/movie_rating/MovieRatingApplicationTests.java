package com.antra.movie_rating;

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
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
public class MovieRatingApplicationTests {

	@Autowired
	UserRoleRepository roleRepository;
	//@Test
	public void contextLoads() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("1234"));
	}
//	@Test
	@Transactional
	public void testRoleDAO() {
		System.out.println(roleRepository.findAll().size());
	}

}

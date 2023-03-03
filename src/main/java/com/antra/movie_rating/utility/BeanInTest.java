package com.antra.movie_rating.utility;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("test")
public class BeanInTest {
    @PostConstruct
    private void init() {
        System.out.println("here is test***");
    }
}

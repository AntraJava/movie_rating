package com.antra.movie_rating.dao;

import com.antra.movie_rating.domain.RoleName;
import com.antra.movie_rating.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

	Optional<UserRole> findByName(RoleName roleUser);
}

package com.antra.movie_rating.dao;

import com.antra.movie_rating.domain.RoleName;
import com.antra.movie_rating.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

	Optional<UserRole> findByName(RoleName roleUser);

	@Modifying
	@Query(value = "delete from user_role where `name` = :roleName and user_id = :userId",nativeQuery = true)
	int deleteByRoleAndUserId(String roleName, Integer userId);
}

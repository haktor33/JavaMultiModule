package com.haktor.repostories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haktor.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUsername(String userName);
    User getById(Long id);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}

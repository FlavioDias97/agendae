package com.free.agendae.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.free.agendae.model.User;

@Repository("User")
public interface UserRepository extends JpaRepository<User, Long> {
	
	

}

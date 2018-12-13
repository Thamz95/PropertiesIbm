package com.aditi.insight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aditi.insight.domain.User;


public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmailIgnoreCase(String email);
	
	User findByMobile(String mobile);
}

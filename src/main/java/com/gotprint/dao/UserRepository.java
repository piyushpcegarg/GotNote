package com.gotprint.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gotprint.model.UserMst;

public interface UserRepository extends JpaRepository<UserMst, Long> {
	
	UserMst findByEmailIdAndPassword(String emailId , String password);

}

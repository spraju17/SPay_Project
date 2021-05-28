package com.spraju.spay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spraju.spay.entity.UserEntity;

public interface UserDAO extends JpaRepository<UserEntity, Integer> {
	
	@Query("select user.phoneNumber from UserEntity user where user.emailId= :emailid")
	String getPhoneNumberByEmailId (@Param("emailid") String emailid);
	
	@Query("select user.password,user.userId from UserEntity user where user.emailId= :emailid")
	List<Object[]> getPasswordByEmailId (@Param("emailid") String emailid);
	
}

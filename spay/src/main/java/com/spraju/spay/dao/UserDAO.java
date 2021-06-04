package com.spraju.spay.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spraju.spay.entity.AddressEntity;
import com.spraju.spay.entity.CardEntity;
import com.spraju.spay.entity.UserEntity;

public interface UserDAO extends JpaRepository<UserEntity, Integer> {
	
	@Query("select user.phoneNumber from UserEntity user where user.emailId= :emailid")
	String getPhoneNumberByEmailId (@Param("emailid") String emailid);
	
	@Query("select user.password,user.userId from UserEntity user where user.emailId= :emailid")
	List<Object[]> getPasswordandUserIDByEmailId (@Param("emailid") String emailid);
	
	@Query("select user.securityQuestionAnswer from UserEntity user where user.emailId= :emailid")
	String getSecurityQuestionAnswerByEmailId (@Param("emailid") String emailid);
	
	@Transactional
	@Modifying
	@Query("update UserEntity user set user.password=:newPassword where user.emailId=:emailid")
	void resetPassword(@Param("emailid") String emailid,@Param("newPassword") String newPassword);
	
	@Query("select user.cardEntities from UserEntity user where user.userId=:userid")
	List<CardEntity> getUserCardsByUserid(@Param("userid") Integer userid);
	
	@Query("select user.addressEntity from UserEntity user where user.userId=:userid")
	AddressEntity getAddressByUserid(@Param("userid") Integer userid);
	
}

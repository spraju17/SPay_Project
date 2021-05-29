package com.spraju.spay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spraju.spay.entity.AddressEntity;

public interface AddressDAO extends JpaRepository<AddressEntity, Integer> {

}

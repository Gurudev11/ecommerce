package com.monkmaze.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monkmaze.ecommerce.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}

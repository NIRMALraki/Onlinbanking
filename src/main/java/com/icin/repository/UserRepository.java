package com.icin.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icin.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}

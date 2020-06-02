package com.fincovi.assessment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fincovi.assessment.domain.User;

import javax.transaction.Transactional;


public interface UserRepository extends JpaRepository<User, Integer> {

  boolean existsByUsername(String username);

  User findByUsername(String username);

  @Transactional
  void deleteByUsername(String username);

}

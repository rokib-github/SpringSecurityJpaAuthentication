package com.rokib.springSecurityJpaAuthentication.persistence.repository;

import com.rokib.springSecurityJpaAuthentication.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);
}

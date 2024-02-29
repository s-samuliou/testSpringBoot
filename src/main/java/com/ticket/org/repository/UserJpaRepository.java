package com.ticket.org.repository;

import com.ticket.org.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, UserService> {

    Optional<UserEntity> findAllByLogin(String login);
}


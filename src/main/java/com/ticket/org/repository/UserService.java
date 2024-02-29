package com.ticket.org.repository;

import com.ticket.org.entity.UserEntity;
import com.ticket.org.model.dto.UserDto;

import java.util.List;

public interface UserService {
    
    UserEntity create(UserEntity userEntity);//ничего не надо делать тк он сужествует в jpa
    
    UserEntity getByLogin(String login);

    List<UserEntity> getAll();
}

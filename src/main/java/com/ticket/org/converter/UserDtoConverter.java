package com.ticket.org.converter;

import com.ticket.org.entity.UserEntity;
import com.ticket.org.model.dto.UserDto;

public class UserDtoConverter implements Converter {


    public UserDto toDto(UserEntity userEntity) {
        return new UserDto(
                userEntity.getId(),
                userEntity.getLogin(),
                userEntity.getEmail(),
                userEntity.getRole().name());
    }

    @Override
    public Object toDto(Object o) {
        return toDto(o);
    }

    @Override
    public Object toEntity(Object o) {
        return null;
    }

    /*@Override
    public Object toEntity(UserDto userDto) {
        return new UserEntity();
    }*/
}

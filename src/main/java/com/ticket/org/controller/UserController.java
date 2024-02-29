package com.ticket.org.controller;

import com.ticket.org.converter.Converter;
import com.ticket.org.entity.UserEntity;
import com.ticket.org.model.dto.UserDto;
import com.ticket.org.repository.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    private final Converter<UserEntity, UserDto> converter;

    public UserController(UserService userService, Converter<UserEntity, UserDto> converter) {
        this.userService = userService;
        this.converter = converter;
    }

    @GetMapping
    public List<UserDto> list() {
        return userService.getAll()
                .stream()
                .map(converter::toDto)
                .collect(Collectors.toList());

    }

    @PostMapping
    public UserDto create(@RequestBody UserDto dto) {
        UserEntity entity1 = converter.toEntity(dto);
        UserEntity entity = userService.create(entity1);
        return converter.toDto(entity);
    }
}

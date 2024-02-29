package com.ticket.org.service;

import com.ticket.org.entity.UserEntity;
import com.ticket.org.exceptions.UserNotFoundException;
import com.ticket.org.repository.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    Map<String, String> userStorage = Map.of(
            "admin", "$2a$10$ZUqPj8reWgjPoLvy92bobOpzEGn1/nSCY9TarapgrnHSQqJxD.Fca",
            "user", "$2a$10$tvO93VUoW15RGX0EUoJnzuacg4RPPPDW2Nmls0G1oNBbHfMsCiVqi"
    );

    private final UserService userService;

    public UserDetailService(UserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity;

        try {
            userEntity = userService.getByLogin(username);
        } catch (UserNotFoundException exception) {
            throw new UsernameNotFoundException(exception.getMessage());
        }

        return new User(userEntity.getLogin(), userEntity.getPassword(), Collections.singleton(userEntity.getRole()));
    }
}

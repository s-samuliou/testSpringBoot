package com.ticket.org.repository;

import com.ticket.org.entity.UserEntity;
import com.ticket.org.exceptions.UserNotFoundException;
import com.ticket.org.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //создаёт все необход конструкторы которые ему жизненно необходимо
public class UserServiceImpl implements UserService {

    private final UserJpaRepository repository; //инжект через конструктор v

    public UserServiceImpl(UserJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserEntity create(UserEntity userEntity) {
        return null;
    }

    @Override
    public UserEntity getByLogin(String login) {
        return repository.findAllByLogin(login).orElseThrow(
                () -> {throw new UserNotFoundException("User with login " + login + "not found");}
        );
    }

    @Override
    public List<UserEntity> getAll() {
        return repository.findAll();
    }
}

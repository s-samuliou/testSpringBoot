package com.ticket.org.entity;

import com.ticket.org.model.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_account")
@Data //не надо писать конструктор(для этих 4х полей) + базовые методы(settes gets)
@NoArgsConstructor //создание пустого конструктора без аргументов
public class UserEntity {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private long id;

    private String login;

    private String password;

    @Email
    private String email;

    @Enumerated(EnumType.STRING) //Если не поставить аннтацию, то буит отображаться цифры вместо стринги
    private Role role;

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public UserEntity(String login, String password, String email, Role role) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}

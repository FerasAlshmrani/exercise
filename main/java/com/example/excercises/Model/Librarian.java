package com.example.excercises.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Librarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotEmpty(message = "username should be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String username;

    @NotEmpty(message = "password should be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d).+$")
    private String password;

    @Email
    @NotEmpty(message = "email should be not empty")
    @Column(columnDefinition = "varchar(20) unique ")

    private String email;

}

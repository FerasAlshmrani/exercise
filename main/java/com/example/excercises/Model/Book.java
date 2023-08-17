package com.example.excercises.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(20) unique not null")
    @NotEmpty(message = "title should be not empty")
    private String title;

    @NotEmpty(message = "author should be not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String author;

    @NotEmpty(message = "category should be not empty")

    @Column(columnDefinition = "varchar(20) check(category='academic' or category='mystery' or category = 'novel') ")
    private String category;

    @NotNull(message = "isbn should be not empty")
    @Column(columnDefinition = "int not null")
    private Integer isbn;

    @Column(columnDefinition = "int check(numberofpages >= 50)")
    private Integer numberofpages;

}

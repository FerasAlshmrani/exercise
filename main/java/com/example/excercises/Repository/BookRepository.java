package com.example.excercises.Repository;


import com.example.excercises.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

Book getBookById(Integer id);
List<Book> getBookByCategory(String category);

@Query("select b from Book b where b.numberofpages >300")
List<Book> getBookByNumberofpages();

List<Book>getBookByAuthor(String Author);


Book searchBookByTitle(String title);



}

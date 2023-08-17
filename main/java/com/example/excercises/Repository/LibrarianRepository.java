package com.example.excercises.Repository;

import com.example.excercises.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Integer> {

    Librarian getLibrarianById(Integer id);

    Librarian getLibrarianByUsernameAndPassword(String username,String password);

    Librarian getLibrarianByEmail(String email);


}

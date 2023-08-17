package com.example.excercises.Service;

import com.example.excercises.ApiResponse.ApiException;
import com.example.excercises.Model.Librarian;
import com.example.excercises.Repository.LibrarianRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {

    private final LibrarianRepository librarianRepository;

    public List<Librarian> getAllLibrarian(){
        return librarianRepository.findAll();
    }

    public void addLibrarian(Librarian librarian){
        librarianRepository.save(librarian);
    }

    public void updateLibrarian(Librarian librarian,Integer id){
        Librarian oldLibrarian = librarianRepository.getLibrarianById(id);
        if(oldLibrarian == null){
            throw new ApiException("wrong id");
        }
        oldLibrarian.setName(librarian.getName());
        oldLibrarian.setUsername(librarian.getUsername());
        oldLibrarian.setPassword(librarian.getPassword());
        oldLibrarian.setEmail(librarian.getEmail());
        librarianRepository.save(oldLibrarian);
    }

    public void deleteLibrarian(Integer id){
        Librarian findLibrarian = librarianRepository.getLibrarianById(id);
        if(findLibrarian == null){
            throw new ApiException("wrong id");
        }
        librarianRepository.delete(findLibrarian);
    }

    public Librarian getLibrarianById(Integer id){
        Librarian findLibrarian = librarianRepository.getLibrarianById(id);
        if(librarianRepository.findAll() == null){
            throw new ApiException("Wrong id");
        }
        return findLibrarian;
    }
    public Librarian checkLogin(String username,String password){
        Librarian librarian=librarianRepository.getLibrarianByUsernameAndPassword(username,password);
        if(librarian == null){
            throw new ApiException("Username or Password is wrong");
        }
        return librarian;
    }
    public Librarian checkemail(String email){
        Librarian librarian=librarianRepository.getLibrarianByEmail(email);
        if(librarian == null){
            throw new ApiException("email is wrong");
        }
        return librarian;
    }

}

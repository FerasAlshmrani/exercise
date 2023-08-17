package com.example.excercises.Controller;

import com.example.excercises.ApiResponse.ApiResponse;
import com.example.excercises.Model.Librarian;
import com.example.excercises.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/librarian")
public class LibrarianController {

    private final LibrarianService librarianService;

    @GetMapping("/get")
    public ResponseEntity getLibrarians(){
        return ResponseEntity.status(200).body(librarianService.getAllLibrarian());
    }

    @PostMapping("/add")
    public ResponseEntity addLibrarian(@RequestBody @Valid Librarian librarian){
        librarianService.addLibrarian(librarian);
        return ResponseEntity.status(200).body(new ApiResponse("Book added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateLibrarian(@RequestBody @Valid Librarian librarian , @PathVariable Integer id){
        librarianService.updateLibrarian(librarian,id);
        return ResponseEntity.status(200).body(new ApiResponse("Book Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLibrarian(@PathVariable Integer id){
        librarianService.deleteLibrarian(id);
        return ResponseEntity.status(200).body(new ApiResponse("Book deleted"));
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity getById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(librarianService.getLibrarianById(id));
    }

    @GetMapping("/get-by-login/{username}/{password}")
    public ResponseEntity login(@PathVariable String username,@PathVariable String password){
        return ResponseEntity.status(200).body(librarianService.checkLogin(username,password));
    }

    @GetMapping("/get-by-email/{email}")
    public ResponseEntity getByCategory(@PathVariable String email){
        return ResponseEntity.status(200).body(librarianService.checkemail(email));
    }






}

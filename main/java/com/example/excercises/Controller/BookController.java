package com.example.excercises.Controller;


import com.example.excercises.ApiResponse.ApiResponse;
import com.example.excercises.Model.Book;
import com.example.excercises.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookService bookService;

    @GetMapping("/get")
    public ResponseEntity getBooks(){
        return ResponseEntity.status(200).body(bookService.getAllBooks());
    }

    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody @Valid Book book){
        bookService.addBook(book);
        return ResponseEntity.status(200).body(new ApiResponse("Book added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@RequestBody @Valid Book book , @PathVariable Integer id){
        bookService.updateBook(book,id);
        return ResponseEntity.status(200).body(new ApiResponse("Book Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body(new ApiResponse("Book deleted"));
    }

    @GetMapping("/get-by-category/{category}")
    public ResponseEntity getByCategory(@PathVariable String category){
        return ResponseEntity.status(200).body(bookService.getBooksByCategory(category));
    }

    @GetMapping("/get-pages")
    public ResponseEntity getBooksByPages(){
        return ResponseEntity.status(200).body(bookService.getBooksByPagesMoreThan300());
    }

    @GetMapping("/get-by-author/{author}")
    public ResponseEntity getByAuthor(@PathVariable String author){
        return ResponseEntity.status(200).body(bookService.getBooksByAuthor(author));
    }

    @GetMapping("/search-by-title/{title}")
    public ResponseEntity SearchByTitle(@PathVariable String title){
        return ResponseEntity.status(200).body(bookService.searchBookByTitle(title));
    }



}

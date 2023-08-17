package com.example.excercises.Service;

import com.example.excercises.ApiResponse.ApiException;
import com.example.excercises.Model.Book;
import com.example.excercises.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void updateBook(Book book,Integer id){
        Book oldBook = bookRepository.getBookById(id);

        if(oldBook == null){
            throw new ApiException("wrong id");
        }
        oldBook.setTitle(book.getTitle());
        oldBook.setAuthor(book.getAuthor());
        oldBook.setCategory(book.getCategory());
        oldBook.setIsbn(book.getIsbn());
        oldBook.setNumberofpages(book.getNumberofpages());

        bookRepository.save(oldBook);
    }

    public void deleteBook(Integer id){
        Book findBook = bookRepository.getBookById(id);

        if(findBook == null){
            throw new ApiException("wrong id");
        }
        bookRepository.delete(findBook);
    }

    public List<Book> getBooksByCategory(String category){
        List<Book> books= bookRepository.getBookByCategory(category);
        if (books.isEmpty()){
            throw new ApiException("is empty");
        }
        return books;
    }

    public List<Book> getBooksByPagesMoreThan300(){
        List<Book> books= bookRepository.getBookByNumberofpages();
        if (books.isEmpty()){
            throw new ApiException("there are no books that have more than 300");
        }
        return books;
    }
    public List<Book> getBooksByAuthor(String author){
        List<Book> books = bookRepository.getBookByAuthor(author);

        if(books.isEmpty()){
            throw new ApiException("not found");
        }
        return books;
    }

    public Book searchBookByTitle(String title){
        Book book = bookRepository.searchBookByTitle(title);

        if(book == null){
            throw new ApiException("not found");
        }

        return book;
    }



}

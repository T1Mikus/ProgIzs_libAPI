package com.sj.libAPI.services;

import com.sj.libAPI.models.DTO.BookDTO;
import com.sj.libAPI.models.entities.Book;
import com.sj.libAPI.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository _bookRepository;

    public List<Book> getAllBooks() {
        return new ArrayList<>(_bookRepository.findAll());
    }

    public Book getBookById(UUID id) {
        return _bookRepository.findById(id).orElse(null);
    }

    public void addBook(BookDTO bookDTO){
        Book newBook = new Book(bookDTO);
        _bookRepository.save(newBook);
    }

    public void updateBook(UUID id, BookDTO bookDTO){
        Book updatedBook = new Book(bookDTO);
        updatedBook.setId(id);
        _bookRepository.save(updatedBook);
    }

    public void deleteBook(UUID id){
        _bookRepository.deleteById(id);
    }

}

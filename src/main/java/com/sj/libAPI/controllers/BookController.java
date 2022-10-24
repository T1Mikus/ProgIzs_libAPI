package com.sj.libAPI.controllers;

import com.sj.libAPI.models.DTO.BookDTO;
import com.sj.libAPI.models.entities.Book;
import com.sj.libAPI.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService _bookService;

    /*@GetMapping
    public List<Book> getAllBooks(Model model) {
        var books =  _bookService.getAllBooks();
        model.addAttribute("books", books);
        System.out.println(books);
        return books;
    }*/
    @GetMapping
    public String getAllBooks(Model model) {
        var books = (List<Book>) _bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("{id}")
    public Book getBookById(@PathVariable UUID id){
        return _bookService.getBookById(id);
    }

    @PostMapping
    public void addBook(@RequestBody BookDTO bookDTO){
        _bookService.addBook(bookDTO);
    }

    @PutMapping("{id}")
    public void updateBook(@PathVariable UUID id, @RequestBody BookDTO bookDTO){
        _bookService.updateBook(id, bookDTO);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable UUID id){
        _bookService.deleteBook(id);
    }

}

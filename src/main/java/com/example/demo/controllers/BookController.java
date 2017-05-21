package com.example.demo.controllers;

import com.example.demo.domain.Book;

import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by kraet on 16.05.2017.
 */
@RestController
public class BookController {

    @Autowired
    public BookService bookService;


    @PostMapping("/books/add")
    public Book add(@RequestBody Book book) throws IOException {
        return bookService.add(book);
    }
    @PostMapping("/books/delete")
    public void delete(@RequestBody Book book) throws IOException{
        bookService.delete(book);

    }
    @PostMapping("/books/update")
    public Book update(@RequestBody Book book) throws IOException {
        return bookService.update(book);
    }
    @GetMapping("/books/showAll")
    public List<Book> showAll()throws IOException{
        return bookService.list();
    }
}

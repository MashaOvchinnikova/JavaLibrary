package com.example.library.controllers;

import com.example.library.models.Book;
import com.example.library.models.BookGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.library.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Locale;

@Controller
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping(value = "/books")
    @ResponseBody
    public List<Book> getAllBooks()
    {
        return bookService.getAllBooks();
    }

    @GetMapping(value ="/save/{genre}/{author}/{name}")
    @ResponseBody
    public Book saveBook(@PathVariable String genre, @PathVariable String name, @PathVariable String author)
    {
        genre = genre.toUpperCase(Locale.ROOT);
        return bookService.saveBook(name, author, BookGenre.valueOf(genre));
    }

}

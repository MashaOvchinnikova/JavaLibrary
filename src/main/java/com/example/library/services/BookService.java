package com.example.library.services;

import com.example.library.models.Book;
import com.example.library.models.BookGenre;
import com.example.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {
   private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks()
    {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    public Book saveBook(String name, String author, BookGenre genre)
    {
        Book book = new Book(name, author, genre);
        bookRepository.save(book);
        return book;
    }

}

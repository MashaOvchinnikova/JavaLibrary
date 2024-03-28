package com.example.library.services;

import com.example.library.models.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {
    protected List<Book> books = new ArrayList<>();

    public BookService () {
        books.add(new Book("Дубровский", "А.С. Пушкин"));
        books.add(new Book("Джейн Эйр", "Шарлотта Бронте"));
    }

    public List<Book> getAllBooks() {
        return books;
    }
}

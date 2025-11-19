package com.spring.spring6webapp.services;

import com.spring.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}

package com.spring.spring6webapp.services;

import com.spring.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}

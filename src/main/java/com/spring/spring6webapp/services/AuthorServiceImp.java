package com.spring.spring6webapp.services;

import com.spring.spring6webapp.domain.Author;
import com.spring.spring6webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImp implements AuthorService{

    private final AuthorRepository authorRepository;

    public AuthorServiceImp(AuthorRepository authorRepository) {

        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {

        return authorRepository.findAll();
    }
}

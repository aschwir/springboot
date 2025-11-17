package com.spring.spring6webapp.bootstrap;

import com.spring.spring6webapp.domain.Author;
import com.spring.spring6webapp.domain.Book;
import com.spring.spring6webapp.repositories.AuthorRepository;
import com.spring.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private  final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author Eric = new Author();
        Eric.setFirstName("Eric");
        Eric.setLastName("Smith");

        Author Rod = new Author();
        Eric.setFirstName("Rod");
        Eric.setLastName("Washington");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Book noEJB = new Book();
        noEJB.setTitle("J2ee Development without EJ8");
        noEJB.setIsbn("789123");

        Author ericSaved = authorRepository.save(Eric);
        Author rodSaved = authorRepository.save(Rod);
        Book dddSaved = bookRepository.save(ddd);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        System.out.println("In bootstrap data");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());


    }


}

package com.spring.spring6webapp.bootstrap;

import com.spring.spring6webapp.domain.Author;
import com.spring.spring6webapp.domain.Book;
import com.spring.spring6webapp.domain.Publisher;
import com.spring.spring6webapp.repositories.AuthorRepository;
import com.spring.spring6webapp.repositories.BookRepository;
import com.spring.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private  final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher DomainPublishing = new Publisher();
        DomainPublishing.setName("Domain Publishing" );
        DomainPublishing.setAddress("111 2nd street");
        DomainPublishing.setCity("Tampa");
        DomainPublishing.setState("Florida");
        DomainPublishing.setZip("45678");

        Publisher DomainPublishingSaved = publisherRepository.save(DomainPublishing);


        Author Eric = new Author();
        Eric.setFirstName("Eric");
        Eric.setLastName("Smith");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        ddd.setPublisher(DomainPublishingSaved);
        ddd.getAuthors().add(Eric);
        Eric.getBooks().add(ddd);

        authorRepository.save(Eric);
        bookRepository.save(ddd);

        Author Rod = new Author();
        Rod.setFirstName("Rod");
        Rod.setLastName("Washington");

        Book noEJB = new Book();
        noEJB.setTitle("J2ee Development without EJ8");
        noEJB.setIsbn("789123");

        noEJB.setPublisher(DomainPublishingSaved);
        noEJB.getAuthors().add(Rod);
        Rod.getBooks().add(noEJB);

        authorRepository.save(Rod);
        bookRepository.save(noEJB);


        System.out.println("In bootstrap data");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());


    }


}

package gov.texas.dfps.SpringClass.bootstrap;

import gov.texas.dfps.SpringClass.domain.Author;
import gov.texas.dfps.SpringClass.domain.Book;
import gov.texas.dfps.SpringClass.domain.Publisher;
import gov.texas.dfps.SpringClass.repositories.AuthorRepository;
import gov.texas.dfps.SpringClass.repositories.BookRepository;
import gov.texas.dfps.SpringClass.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design", "123456");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB","2345678");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Number of books "+bookRepository.count());

        Publisher pp = new Publisher("Pragmatic Programmer");
        pp.setCity("Austin");
        pp.setState("Texas");
        pp.setAddress1("101 E. 6th Street");
        pp.setZip("77001");

        publisherRepository.save(pp);

        ddd.setPublisher(pp);
        noEJB.setPublisher(pp);
        bookRepository.save(ddd);
        bookRepository.save(noEJB);

        System.out.println("Number of books: "+bookRepository.count());
        System.out.println("Number of authors: "+authorRepository.count());
        System.out.println("Number of publishers: "+publisherRepository.count());

    }
}

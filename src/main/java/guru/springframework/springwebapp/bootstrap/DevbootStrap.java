package guru.springframework.springwebapp.bootstrap;

import guru.springframework.springwebapp.model.Book;
import guru.springframework.springwebapp.model.Publisher;
import guru.springframework.springwebapp.repository.AuthorRepository;
import guru.springframework.springwebapp.model.Author;
import guru.springframework.springwebapp.repository.BookRepository;
import guru.springframework.springwebapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by dannybastos on 29/10/18.
 */
@Component
public class DevbootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevbootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Author eric = new Author("eric", "evans");
        Publisher harper = new Publisher("Harper Colling");
        Book ddd = new Book("Domain Drive Design", "1234", harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Author rod = new Author("rod", "johnson");
        Publisher mitch = new Publisher("MITCH");
        Book jee = new Book("JEE Development without EJB", "1234", mitch);
        rod.getBooks().add(jee);
        jee.getAuthors().add(rod);

        publisherRepository.save(harper);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        publisherRepository.save(mitch);
        authorRepository.save(rod);
        bookRepository.save(jee);
    }
}

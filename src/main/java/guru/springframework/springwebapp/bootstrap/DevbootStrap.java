package guru.springframework.springwebapp.bootstrap;

import guru.springframework.springwebapp.model.Author;
import guru.springframework.springwebapp.model.Book;
import guru.springframework.springwebapp.repository.AuthorRepository;
import guru.springframework.springwebapp.repository.BookRepository;
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

    public DevbootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Author eric = new Author("eric", "evans");
        Book ddd = new Book("Domain Drive Design", "1234", "Harper Colling");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Author rod = new Author("rod", "johnson");
        Book jee = new Book("JEE Development without EJB", "1234", "MITCH");
        rod.getBooks().add(jee);
        jee.getAuthors().add(rod);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        authorRepository.save(rod);
        bookRepository.save(jee);
    }
}

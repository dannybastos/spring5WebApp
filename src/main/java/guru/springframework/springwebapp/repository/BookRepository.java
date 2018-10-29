package guru.springframework.springwebapp.repository;

import guru.springframework.springwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dannybastos on 29/10/18.
 */
public interface BookRepository extends CrudRepository<Book, Integer> {
}

package guru.springframework.springwebapp.repository;

import guru.springframework.springwebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dannybastos on 29/10/18.
 */
public interface AuthorRepository extends CrudRepository<Author, Integer> {
}

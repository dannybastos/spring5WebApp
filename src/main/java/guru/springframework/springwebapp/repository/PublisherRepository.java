package guru.springframework.springwebapp.repository;

import guru.springframework.springwebapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dannybastos on 29/10/18.
 */
public interface PublisherRepository extends CrudRepository<Publisher, Integer> {
}

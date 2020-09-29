package ua.test.task.repo;

import org.springframework.data.repository.CrudRepository;
import ua.test.task.models.Superhero;

public interface SuperheroRepository extends CrudRepository<Superhero, Long> {
}

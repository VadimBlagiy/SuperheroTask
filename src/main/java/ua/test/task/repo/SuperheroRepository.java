package ua.test.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.test.task.models.Superhero;

public interface SuperheroRepository extends JpaRepository <Superhero, Long> {
}

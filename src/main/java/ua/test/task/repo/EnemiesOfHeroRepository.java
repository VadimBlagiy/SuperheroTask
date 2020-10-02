package ua.test.task.repo;

import org.springframework.data.repository.CrudRepository;
import ua.test.task.models.Enemies;
import ua.test.task.models.Friends;

public interface EnemiesOfHeroRepository extends CrudRepository<Enemies, Long> {
}

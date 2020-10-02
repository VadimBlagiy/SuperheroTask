package ua.test.task.repo;

import org.springframework.data.repository.CrudRepository;
import ua.test.task.models.Friends;
import ua.test.task.models.Superhero;

public interface FriendsOfHeroRepository extends CrudRepository<Friends, Long> {
}

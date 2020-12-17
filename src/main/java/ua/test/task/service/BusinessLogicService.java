package ua.test.task.service;

import ua.test.task.dto.FriendsIds;
import ua.test.task.dto.SuperheroRequest;
import ua.test.task.models.Superhero;

import java.util.List;

public interface BusinessLogicService {
    List<Superhero> findAll();

    Superhero findById(long superheroId);

    void deleteById(long id);

    Superhero createSuperhero(SuperheroRequest superheroRequest);

    Superhero updateSuperhero(long id, SuperheroRequest superheroRequest);

    Superhero addFriends(long id, FriendsIds newFriends);

//    Superhero addEnemy(long id, FriendsIds friendsIds);
}

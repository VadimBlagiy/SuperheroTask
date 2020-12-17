package ua.test.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.test.task.dto.FriendsIds;
import ua.test.task.dto.SuperheroRequest;
import ua.test.task.exception.ResourceNotFoundException;
import ua.test.task.models.Superhero;
import ua.test.task.repository.SuperheroRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuperheroService implements BusinessLogicService {

    private SuperheroRepository superheroRepository;

    @Autowired
    public SuperheroService(SuperheroRepository superheroRepository) {
        this.superheroRepository = superheroRepository;
    }

    @Override
    public List<Superhero> findAll() {
        return  superheroRepository.findAll();
    }

    @Override
    public Superhero findById(long superheroId) {
        return superheroRepository.findById(superheroId)
                .orElseThrow(() -> new ResourceNotFoundException("Superhero", "ID", superheroId));
    }

    @Override
    public void deleteById(long id) {

        superheroRepository.deleteById(id);
    }
    @Override
    public Superhero createSuperhero(SuperheroRequest superheroRequest) {
        Superhero superhero = new Superhero();
        superhero.setName(superheroRequest.getName());
        superhero.setFirstName(superheroRequest.getFirstName());
        superhero.setLastName(superheroRequest.getLastName());
        superhero.setAge(superheroRequest.getAge());
        superhero.setSuper_power(superheroRequest.getSuper_power());
        return superheroRepository.save(superhero);
    }

    @Override
    public Superhero updateSuperhero(long id, SuperheroRequest superheroRequest) {
        Superhero superhero = superheroRepository.getOne(id);
            superhero.setName(superheroRequest.getName());
            superhero.setFirstName(superheroRequest.getFirstName());
            superhero.setLastName(superheroRequest.getLastName());
            superhero.setAge(superheroRequest.getAge());
            superhero.setSuper_power(superheroRequest.getSuper_power());
            return superheroRepository.save(superhero);
        }



        //все непагано  АЛЕ не працю наступне: добавити друзів та ворогів не виходить!!!!(((

    @Override
    public Superhero addFriends(long id, FriendsIds newFriends) {
        Superhero friendlySuperhero = superheroRepository.getOne(id);
        List<Superhero> allHeroes = superheroRepository.findAll();
        List<Superhero> heroesToAdd = allHeroes.stream().filter(hero -> newFriends.getFriends().contains(hero.getId()))
                .collect(Collectors.toList());
        friendlySuperhero.setFriends(heroesToAdd);
        return superheroRepository.save(friendlySuperhero);
    }

//    @Override
//    public Superhero addEnemy(long id, FriendsIds friendsIds) {
////        Superhero superhero = superheroRepository.getOne(id);
////        superhero.setEnemies(friendsIds.getEnemies());
//        return superheroRepository.save(superhero);
//    }
}

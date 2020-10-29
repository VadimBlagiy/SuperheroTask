package ua.test.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.test.task.dto.SuperheroRequest;
import ua.test.task.exception.ResourceNotFoundException;
import ua.test.task.models.Superhero;
import ua.test.task.repository.SuperheroRepository;

import java.util.List;

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
        superhero.setFriends(superheroRequest.getFriends());
        superhero.setEnemies(superheroRequest.getEnemies());
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
            superhero.setFriends(superheroRequest.getFriends());
            superhero.setEnemies(superheroRequest.getEnemies());
            return superheroRepository.save(superhero);
        }

    @Override
    public Superhero addFriend(long id, SuperheroRequest superheroRequest) {
        Superhero superhero = superheroRepository.getOne(id);
        superhero.setFriends(superheroRequest.getFriends());
        return superheroRepository.save(superhero);
    }

    @Override
    public Superhero addEnemy(long id, SuperheroRequest superheroRequest) {
        Superhero superhero = superheroRepository.getOne(id);
        superhero.setEnemies(superheroRequest.getEnemies());
        return superheroRepository.save(superhero);
    }
}

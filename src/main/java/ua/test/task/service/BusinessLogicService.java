package ua.test.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.test.task.models.Superhero;
import ua.test.task.repo.SuperheroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessLogicService {

    private SuperheroRepository superheroRepository;

    @Autowired
    public BusinessLogicService(SuperheroRepository superheroRepository) {
        this.superheroRepository = superheroRepository;
    }


    public List<Superhero> findAll() {

        return  superheroRepository.findAll();
    }

    public void save(Superhero superhero) {
        superheroRepository.save(superhero);
    }


    public Optional<Superhero> findById(long heroid) {
        return superheroRepository.findById(heroid);
    }


    public boolean existsById(long id) {
        return superheroRepository.existsById(id);
    }

    public Superhero getOne(long id) {
        return superheroRepository.getOne(id);
    }

    public void deleteById(long id) {
        superheroRepository.deleteById(id);
    }
}

package ua.test.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.test.task.dto.SuperheroRequest;
import ua.test.task.dto.SuperheroResponse;
import ua.test.task.models.Superhero;
import ua.test.task.service.SuperheroService;

import java.util.List;

@RestController
public class SuperheroController {

    private SuperheroService superheroService;

    @Autowired
    public void superheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }

    @RequestMapping(value = "/superhero", method = RequestMethod.GET)
    public Object allHero() {
        Iterable<Superhero> best = superheroService.findAll();
        return best;
    }

    @RequestMapping(value = "/superhero", method = RequestMethod.POST)
    public Superhero superheroAdd(SuperheroRequest superheroRequest) {
        return superheroService.createSuperhero(superheroRequest);
    }

    @RequestMapping(value = "/superhero/{id}", method = RequestMethod.GET)
    public SuperheroResponse superheroDetails(@PathVariable(value = "id") long superheroId) {
        Superhero superhero = superheroService.findById(superheroId);
        return new SuperheroResponse(superhero.getName(), superhero.getFirstName(), superhero.getLastName(),
                superhero.getAge(), superhero.getSuper_power(), superhero.getFriends(), superhero.getEnemies());
    }

    @RequestMapping(value = "/superhero/{id}", method = RequestMethod.PUT)
    public Object heroUpdate(@PathVariable(value = "id") long id, SuperheroRequest superheroRequest) {
        return superheroService.updateSuperhero(id ,superheroRequest);
    }

    @RequestMapping(value = "/superhero/{id}", method = RequestMethod.DELETE)
    public void heroDelete(@PathVariable(value = "id") long id) {
        superheroService.deleteById(id);
    }

    @RequestMapping(value = "/superhero/{id}/friends", method = RequestMethod.POST)
    public Object addFriendSuperhero(@PathVariable(value = "id") long id,
                                     @RequestParam List<Long> friends,SuperheroRequest superheroRequest) {
        return superheroService.addFriend(id, superheroRequest);
    }

    @RequestMapping(value = "/superhero/{id}/enemies", method = RequestMethod.POST)
    public Object addEnemySuperhero(@PathVariable(value = "id") long id,
                                    @RequestParam List<Long> enemies, SuperheroRequest superheroRequest) {
        return superheroService.addEnemy(id, superheroRequest);
    }

}

package ua.test.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.test.task.dto.FriendsIds;
import ua.test.task.dto.SuperheroRequest;
import ua.test.task.dto.SuperheroResponse;
import ua.test.task.models.Superhero;
import ua.test.task.service.SuperheroService;

import java.util.ArrayList;

@RestController()
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
    public Superhero superheroAdd(@RequestBody SuperheroRequest superheroRequest) {
        return superheroService.createSuperhero(superheroRequest);
    }

    @RequestMapping(value = "/superhero/{id}", method = RequestMethod.GET)
    public SuperheroResponse superheroDetails(@PathVariable(value = "id") long superheroId) {
        Superhero superhero = superheroService.findById(superheroId);
        return new SuperheroResponse(superhero.getName(), superhero.getFirstName(), superhero.getLastName(),
                superhero.getAge(), superhero.getSuper_power(), superhero.getFriends(), superhero.getEnemies());
    }

    @RequestMapping(value = "/superhero/{id}", method = RequestMethod.PUT)
    public Object heroUpdate(@PathVariable(value = "id") long id, @RequestBody SuperheroRequest superheroRequest) {
        return superheroService.updateSuperhero(id ,superheroRequest);
    }

    @RequestMapping(value = "/superhero/{id}", method = RequestMethod.DELETE)
    public void heroDelete(@PathVariable(value = "id") long id) {
        superheroService.deleteById(id);
    }







    //todo зробити щоб добавлялись друзі
    @RequestMapping(value = "/superhero/{id}/friends", method = RequestMethod.PUT)
    public Superhero addFriendSuperhero(@PathVariable(value = "id") long id, @RequestBody FriendsIds newFriends) {
        return superheroService.addFriends(id, newFriends);
    }

    //todo зробити щоб добавлялись вороги
//    @RequestMapping(value = "/superhero/{id}/enemies", method = RequestMethod.PUT)
//    public Superhero addEnemySuperhero(@PathVariable(value = "id") long id,   @RequestBody FriendsIds friendsIds) {
//        return superheroService.addEnemy(id, friendsIds);
//    }

}

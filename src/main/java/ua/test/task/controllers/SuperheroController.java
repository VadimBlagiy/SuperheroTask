package ua.test.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.test.task.models.Superhero;
import ua.test.task.service.BusinessLogicService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SuperheroController {

    private BusinessLogicService businessLogicService;

    @Autowired
    public void superheroController(BusinessLogicService businessLogicService) {
        this.businessLogicService = businessLogicService;
    }


    @RequestMapping(value = "/superhero", method = RequestMethod.GET)
    public Object allHero() {
        Iterable<Superhero> best = businessLogicService.findAll();
        return best;
    }


    @RequestMapping(value = "/superhero/add", method = RequestMethod.POST)
    public Object superheroAdd(@RequestParam String name,
                               @RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam int age,
                               @RequestParam String super_power,
                               @RequestParam List<Superhero> friends,
                               @RequestParam List<Superhero> enemies) {
        Superhero superhero = new Superhero(name, firstName, lastName, age, super_power, friends, enemies);
        businessLogicService.save(superhero);
        return superhero;
    }

    @RequestMapping(value = "/superhero/{id}", method = RequestMethod.GET)
    public Object superheroDetails(@PathVariable(value = "id") long heroid) {
        Optional<Superhero> superhero = businessLogicService.findById(heroid);
        return superhero;
    }


    @RequestMapping(value = "/superhero/{id}/edit-hero", method = RequestMethod.PUT)
    public Object HeroUpdate(@PathVariable(value = "id") long id,
                             @RequestParam String name,
                             @RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam int age,
                             @RequestParam String super_power) {
        Superhero superhero = businessLogicService.getOne(id);
        superhero.setName(name);
        superhero.setFirstName(firstName);
        superhero.setLastName(lastName);
        superhero.setAge(age);
        superhero.setSuper_power(super_power);
        businessLogicService.save(superhero);
        return superhero;
    }


    @RequestMapping(value = "/superhero/{id}/remove-hero", method = RequestMethod.DELETE)
    public void heroDelete(@PathVariable(value = "id") long id) {
        businessLogicService.getOne(id);
        businessLogicService.deleteById(id);
    }


    @RequestMapping(value = "/superhero/{id}/add-friends", method = RequestMethod.POST)
    public Object addFriend (@PathVariable(value = "id") long id, @RequestParam List<Superhero> friends) {
        Optional<Superhero> findAllHeroe = businessLogicService.findById(id);
        Superhero superhero = businessLogicService.getOne(id);
        superhero.setFriends(friends);
        businessLogicService.save(superhero);
        return superhero;
    }


    @RequestMapping(value = "/superhero/{id}/add-enemies", method = RequestMethod.POST)
    public Object addEnemy (@PathVariable(value = "id") long id, @RequestParam List<Superhero> enemies) {
        Optional<Superhero> findAllHeroe = businessLogicService.findById(id);
        Superhero superhero = businessLogicService.getOne(id);
        superhero.setEnemies(enemies);
        businessLogicService.save(superhero);
        return superhero;
    }


    @RequestMapping(value = "/superhero/{id}/remove-friends", method = RequestMethod.DELETE)
    public void friendToDelete(@PathVariable(value = "id") long id, @RequestParam List<Superhero> friends) {
        Superhero superhero = businessLogicService.getOne(id);
        superhero.getFriends().removeAll(friends);
        businessLogicService.save(superhero);
    }


    @RequestMapping(value = "/superhero/{id}/remove-enemy", method = RequestMethod.DELETE)
    public void enemyToDelete(@PathVariable(value = "id") long id, @RequestParam List <Superhero> enemies) {
        Superhero superhero = businessLogicService.getOne(id);
        superhero.getEnemies().removeAll(enemies);
        businessLogicService.save(superhero);
    }


}

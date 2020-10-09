package ua.test.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.test.task.models.Superhero;
import ua.test.task.service.BusinessLogicService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class SuperheroController {

      private BusinessLogicService businessLogicService;

      @Autowired
      public void superheroController(BusinessLogicService businessLogicService) {
      this.businessLogicService = businessLogicService;
      }


    // повертає json
    @RequestMapping(value = "/superhero", method = RequestMethod.GET)
//            produces = { MediaType.APPLICATION_JSON_VALUE })
    public Object allHero() {
         Iterable<Superhero> best = businessLogicService.findAll();
        return best;
    }


    // відправляє json
    @RequestMapping(value = "/superhero/add", method = RequestMethod.POST)
    public Object superheroAdd(@RequestParam String name, @RequestParam String firstName, @RequestParam String lastName,
                               @RequestParam int age, @RequestParam String super_power) {
        Superhero superhero = new Superhero(name, firstName, lastName, age, super_power);
        businessLogicService.save(superhero);
        return superhero;
    }

    // повертає json
    @RequestMapping(value =  "/superhero/{id}", method = RequestMethod.GET)
    public Object superheroDetails(@PathVariable(value = "id") long heroid) {
        Optional<Superhero> superhero = businessLogicService.findById(heroid);
        return superhero;
    }


    //повертає json
    @RequestMapping( value = "/superhero/{id}/edit", method = RequestMethod.GET)
    public Object heroEdit(@PathVariable(value = "id") long id, Model model) {
        if (!businessLogicService.existsById(id)) {
//            return "redirect:/superhero";
        }
        Optional<Superhero> superhero = businessLogicService.findById(id);
        ArrayList<Superhero> res = new ArrayList<>();
        superhero.ifPresent(res::add);
        model.addAttribute("post", res);
        return superhero;
    }


    // оновлює данні
    @RequestMapping(value = "/superhero/{id}/edit", method = RequestMethod.PUT)
    public Object HeroUpdate ( @PathVariable(value = "id") long id,  @RequestParam String name,
                               @RequestParam String firstName,
                               @RequestParam String lastName,  @RequestParam int age,
                               @RequestParam String super_power, Model model) {
        Superhero superhero = businessLogicService.getOne(id);
        superhero.setName(name);
        superhero.setFirstName(firstName);
        superhero.setLastName(lastName);
        superhero.setAge(age);
        superhero.setSuper_power(super_power);
        businessLogicService.save(superhero);
        return superhero;
    }


    // видаляє
    @RequestMapping(value = "/superhero/{id}/remove", method = RequestMethod.DELETE)
    public void heroDelete(@PathVariable(value = "id") long id, Model model) {
      businessLogicService.getOne(id);
        businessLogicService.deleteById(id);
    }

}
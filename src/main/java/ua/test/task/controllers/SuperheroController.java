package ua.test.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.test.task.models.Superhero;
import ua.test.task.repo.SuperheroRepository;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class SuperheroController {

    @Autowired
    private SuperheroRepository superheroRepository;

    @GetMapping("/superhero")
    public String allHero(Model model) {
        Iterable<Superhero> best = superheroRepository.findAll();
        model.addAttribute("best", best);
        return "superhero";
    }

    @GetMapping("/superhero/add")
    public String heroAdd(Model model) {
        return "superhero-add";
    }


    @PostMapping("/superhero/add")
    public String superheroAdd(@RequestParam String name, @RequestParam String firstName, @RequestParam String lastName,
                               @RequestParam int age, @RequestParam String super_power, Model model) {
        Superhero superhero = new Superhero(name, firstName, lastName, age, super_power);
        superheroRepository.save(superhero);
        return "redirect:/superhero";
    }

    @GetMapping("/superhero/{id}")
    public String superheroDetails(@PathVariable(value = "id") long heroid, Model model) {
        Optional<Superhero> superhero = superheroRepository.findById(heroid);
        ArrayList<Superhero> res = new ArrayList<>();
        superhero.ifPresent(res::add);
        model.addAttribute("post", res);
        return "superhero-details";
    }

    @GetMapping("/superhero/{id}/edit")     // {id} динамічна сторінка
    public String heroEdit(@PathVariable(value = "id") long id, Model model) {
        if (!superheroRepository.existsById(id)) {
            return "redirect:/superhero";
        }
        Optional<Superhero> superhero = superheroRepository.findById(id);
        ArrayList<Superhero> res = new ArrayList<>();
        superhero.ifPresent(res::add);
        model.addAttribute("post", res);
        return "superhero-edit";
    }

    @PostMapping("/superhero/{id}/edit")
    public String HeroUpdate (@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String firstName,
                              @RequestParam String lastName, @RequestParam int age,
                              @RequestParam String super_power, Model model) {
        Superhero superhero = superheroRepository.findById(id).orElseThrow(() -> new IllegalStateException ("eror"));
        superhero.setName(name);
        superhero.setFirstName(firstName);
        superhero.setLastName(lastName);
        superhero.setAge(age);
        superhero.setSuper_power(super_power);
        superheroRepository.save(superhero);
        return "redirect:/superhero";
    }

    @PostMapping("/superhero/{id}/remove")
    public String heroDelete(@PathVariable(value = "id") long id, Model model) {
        Superhero superhero = superheroRepository.findById(id).orElseThrow(() -> new IllegalStateException ("eror "));
        superheroRepository.delete(superhero);
        return "redirect:/superhero";
    }

}

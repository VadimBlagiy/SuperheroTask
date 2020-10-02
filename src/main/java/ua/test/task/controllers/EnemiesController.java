package ua.test.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.test.task.models.Enemies;
import ua.test.task.repo.EnemiesOfHeroRepository;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class EnemiesController {

    @Autowired
    private EnemiesOfHeroRepository enemiesOfHeroRepository;

    @GetMapping("/superhero/{id}/enemies")
    public String superheroEnemies(@PathVariable(value = "id") long id, Model model) {
        Optional<Enemies> enemies = enemiesOfHeroRepository.findById(id);
        ArrayList<Enemies> enemy = new ArrayList<>();
        enemies.ifPresent(enemy::add);
        model.addAttribute("enemiesHero", enemy);
        return "enemies";
    }

}

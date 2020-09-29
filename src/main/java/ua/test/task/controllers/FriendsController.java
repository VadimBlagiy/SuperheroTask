package ua.test.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.test.task.models.Friends;
import ua.test.task.models.Superhero;
import ua.test.task.repo.SuperheroRepository;

@Controller
public class FriendsController {

    @Autowired
    private SuperheroRepository superheroRepository;

//    @PostMapping("/superhero/add")
//    public String friendsAdd(@RequestParam String name, Model model) {
//        Friends friends = new Friends();
//        superheroRepository.save(friends);
//        return "redirect:/superhero";
//    }

}



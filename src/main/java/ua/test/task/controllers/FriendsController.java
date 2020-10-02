package ua.test.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.test.task.models.Friends;
import ua.test.task.repo.FriendsOfHeroRepository;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class FriendsController {

    @Autowired
    private FriendsOfHeroRepository friendsOfHeroRepository;

    @GetMapping("/superhero/{id}/friends")
    public String superheroFriends(@PathVariable(value = "id") long id, Model model) {
        Optional<Friends> friends = friendsOfHeroRepository.findById(id);
        ArrayList<Friends> fri = new ArrayList<>();
        friends.ifPresent(fri::add);
        model.addAttribute("friend", fri);
        return "friends";
    }

}



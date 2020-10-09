package ua.test.task.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    //повертає json
    @RequestMapping( value = "/", method = RequestMethod.GET)
    public Object home() {
        List <String> homePage = new ArrayList<>();
     homePage.add("REST service. Technologies used: Spring boot, Postgresql");
        return homePage;
    }

}
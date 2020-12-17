package ua.test.task.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ua.test.task.models.Superhero;

import java.util.List;

public class FriendsIds {


    private List <Superhero> friends;

    public FriendsIds(List<Superhero> friends) {
        this.friends = friends;
    }

    public FriendsIds() {
    }

    public List<Superhero> getFriends() {
        return friends;
    }

    public void setFriends(List<Superhero> friends) {
        this.friends = friends;
    }
}

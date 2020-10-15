package ua.test.task.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Superhero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String firstName;
    private String lastName;
    private int age;
    private String super_power;

    @ManyToMany( fetch = FetchType.LAZY)
    private List <Superhero> friends;

    @ManyToMany ( fetch = FetchType.LAZY)
    private List <Superhero> enemies;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSuper_power() {
        return super_power;
    }

    public void setSuper_power(String super_power) {
        this.super_power = super_power;
    }

    public List<Superhero> getFriends() {
        return friends;
    }

    public void setFriends(List<Superhero> friends) {
        this.friends = friends;
    }

    public List<Superhero> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Superhero> enemies) {
        this.enemies = enemies;
    }

    public Superhero(String name, String firstName, String lastName, int age, String super_power, List<Superhero> friends, List<Superhero> enemies) {
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.super_power = super_power;
        this.friends = friends;
        this.enemies = enemies;
    }

    public Superhero() {
    }

 }

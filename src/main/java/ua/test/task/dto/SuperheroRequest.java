package ua.test.task.dto;

import ua.test.task.models.Superhero;

import java.util.List;


public class SuperheroRequest {


    private String name;
    private String firstName;
    private String lastName;
    private int age;
    private String super_power;


    public SuperheroRequest() {
    }

    public SuperheroRequest(String name, String firstName, String lastName, int age, String super_power) {
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.super_power = super_power;

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


}

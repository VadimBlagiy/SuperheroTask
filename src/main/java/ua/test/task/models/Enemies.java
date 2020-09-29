package ua.test.task.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Enemies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hero_id;
    private String name;

    public Long getHero_id() {
        return hero_id;
    }

    public void setHero_id(Long id) {
        this.hero_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enemies() {
    }

    public Enemies(String name) {
        this.name = name;
    }
}

package ua.test.task.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Friends {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String names;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Friends() {
    }

    public Friends(String names) {
        this.names = names;
    }
}



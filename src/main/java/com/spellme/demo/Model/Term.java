package com.spellme.demo.Model;

import javax.persistence.*;

@Entity

public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String term;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Term() {

    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"term\":\"" + term + '"' +
                '}';
    }
}

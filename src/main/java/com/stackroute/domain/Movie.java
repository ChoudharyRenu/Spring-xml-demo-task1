package com.stackroute.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class Movie {

 @Autowired
 Actor actor;

    public Movie(){

    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Movie(Actor actor) {
        this.actor = actor;
    }


    public void displayActorDetails(){
        System.out.println(actor.name);
    }
}

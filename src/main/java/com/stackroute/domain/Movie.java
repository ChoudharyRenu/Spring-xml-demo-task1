package com.stackroute.domain;

public class Movie {
 private Actor actor;

    public Movie() {
    }

    public Movie(Actor actor) {
        this.actor = actor;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public void displayActorDetails(){
        System.out.println("Name of the actor is "+actor.getName());
        System.out.println("Age of the actor is "+ actor.getAge());
        System.out.println("Actor "+ actor.getName()+ " is a "+ actor.getGender());
    }
}

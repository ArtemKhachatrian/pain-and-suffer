package org.painandsuffer.characters;

import org.painandsuffer.battle.status.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Creature{
    protected String name;
    private int health = 100;




    private List<Status> statuses = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            System.out.println("Incorrect name");
            return;
        }
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health <= 0) {
            System.out.println("Lol " + getName() + " died");
            this.health = 0;
            return;
        }
        this.health = health;
    }
    public List<Status> getStatuses() {
        return statuses;
    }
    public void addStatus(Status status){
        statuses.add(status);
    }
    public void removeStatus(Status status){
        statuses.remove(status);
    }
    public void checkIfAnyStatusExpired(){
        for(Status status : statuses){
            status.removeIfExpired();
        }
    }
}

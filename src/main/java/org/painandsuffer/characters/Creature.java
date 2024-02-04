package org.painandsuffer.characters;

import org.painandsuffer.battle.status.Status;

import java.util.ArrayList;
import java.util.List;

public abstract class Creature {
    protected String name;
    private int health = 100;
    private int armour = 0;
    private int magicProtection = 0;
    private int evasionRate = 0;

    private final List<Status> statuses = new ArrayList<>();

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

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public int getMagicProtection() {
        return magicProtection;
    }

    public void setMagicProtection(int magicProtection) {
        this.magicProtection = magicProtection;
    }

    public int getEvasionRate() {
        return evasionRate;
    }

    public void setEvasionRate(int evasionRate) {
        this.evasionRate = evasionRate;
    }

    public List<Status> getStatuses() {
        return statuses;
    }

    public void addStatus(Status status) {
        statuses.add(status);
    }

    public void removeStatus(Status status) {
        statuses.remove(status);
    }

    public void checkIfAnyStatusExpired() {
        for (Status status : statuses) {
            status.removeIfExpired();
        }
    }
}

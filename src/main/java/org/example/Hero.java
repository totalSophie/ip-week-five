package org.example;

import java.util.Random;

public class Hero {
    String name;
    int age;
    String specialPower;
    String weakness;
    private Squad squad;

    public Hero(String name, int age, String specialPower, String weakness) {
        this.name = name;
        this.age = age;
        this.specialPower = specialPower;
        this.weakness = weakness;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public String getWeakness() {
        return weakness;
    }
    public Squad getSquad() {
        return squad;
    }
    public void joinSquad(Squad squad) {
        if (this.squad == null) {
            this.squad = squad;
            squad.addHero(this);
        } else {
            System.out.println("Hero " + name + " is already part of a squad.");
        }
    }

    public void leaveSquad() {
        if (squad != null) {
            squad.removeHero(this);
            this.squad = null;
        } else {
            System.out.println("Hero " + name + " is not part of any squad.");
        }
    }

    public int calculateOverallScore() {
        // Add a random score to the Heroes
        Random random = new Random();
        return random.nextInt(10) + 1; // Generate a random score between 1 and 10
    }
}

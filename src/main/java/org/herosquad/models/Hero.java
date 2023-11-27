package org.herosquad.models;

import java.util.Random;

public class Hero {
    private static int idCounter = 1;

    private int id;
    private String name;
    private int age;
    private String power;
    private String weakness;
    private Squad squad;

    public Hero(String name, int age, String power, String weakness) {
        this.id = idCounter++;
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
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


    public Squad getSquad() {
        return squad;
    }
    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Hero.idCounter = idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }
}

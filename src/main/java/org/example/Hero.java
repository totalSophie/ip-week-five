package org.example;

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
}

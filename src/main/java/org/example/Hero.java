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
}

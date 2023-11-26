package org.example;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    String name;
    int maxSize;
    String cause;
    List<Hero> heroes;

    public Squad(String name, int maxSize, String cause) {
        this.name = name;
        this.maxSize = maxSize;
        this.cause = cause;
        this.heroes = new ArrayList<>();
    }

    public void addHero(Hero hero) {
        // Check if squad is already full
        if (heroes.size() < maxSize) {
            heroes.add(hero);
            System.out.println(hero.name + " added to " + name + "!");
        } else {
            System.out.println(name + " is already at max size. Cannot add " + hero.name + ".");
        }
    }
    public void removeHero(Hero hero) {
        heroes.remove(hero);
        System.out.println("Hero " + hero.getName() + " left Squad " + name + ".");
    }

    public void displaySquad() {
        System.out.println("Squad: " + name);
        System.out.println("Cause: " + cause);
        System.out.println("Heroes:");
        for (Hero hero : heroes) {
            System.out.println("- " + hero.name);
        }
    }

    public String getName() {
        return name;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public String getCause() {
        return cause;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }
}

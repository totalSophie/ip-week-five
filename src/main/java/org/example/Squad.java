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

    public int calculateSquadScore() {
        // sum up the overall scores of all heroes in the squad
        int totalScore = 0;
        for (Hero hero : heroes) {
            totalScore += hero.calculateOverallScore();
        }
        return totalScore;
    }

    public void battle(Squad opponent) {
        int thisScore = calculateSquadScore();
        int opponentScore = opponent.calculateSquadScore();

        System.out.println("Battle between " + getName() + " and " + opponent.getName());

        if (thisScore > opponentScore) {
            System.out.println(getName() + " wins!");
        } else if (thisScore < opponentScore) {
            System.out.println(opponent.getName() + " wins!");
        } else {
            System.out.println("It's a draw!");
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

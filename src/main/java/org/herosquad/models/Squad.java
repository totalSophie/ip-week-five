package org.herosquad.models;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private static int idCounter = 1;

    private int id;
    private String name;
    private int maxSize;
    private String cause;
    private List<Hero> heroes;

    public Squad(String name, int maxSize, String cause) {
        this.id = idCounter++;
        this.name = name;
        this.maxSize = maxSize;
        this.cause = cause;
        this.heroes = new ArrayList<>();
    }
    public void addHero(Hero hero) {
        // Check if squad is already full
        if (heroes.size() < maxSize) {
            heroes.add(hero);
            System.out.println(hero.getName() + " added to " + name + "!");
        } else {
            System.out.println(name + " is already at max size. Cannot add " + hero.getName() + ".");
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
            System.out.println("- " + hero.getName());
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
    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Squad.idCounter = idCounter;
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

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }
}

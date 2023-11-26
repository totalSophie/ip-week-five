package org.example;

public class Main {
    public static void main(String[] args) {
        Hero homelander = new Hero("Superman",
                              30,
                              "Flight",
                              "Kryptonite");
        Hero starlight = new Hero("Wonder Woman",
                              25,
                              "Lasso of Truth",
                              "Mansplaining");

        Squad justiceLeague = new Squad("Justice League",
                                        5,
                                        "Justice and Equality");
        Squad avengers = new Squad("Avengers",
                                   4,
                                   "Protecting the World");

        homelander.joinSquad(justiceLeague);
        starlight.joinSquad(justiceLeague);

        Hero deep = new Hero("Iron Man",
                              35,
                              "Powered Armor",
                              "Arrogance");
        Hero ironMan = new Hero("Captain America",
                              30,
                              "Superhuman Strength",
                              "Technology");

        deep.joinSquad(avengers);
        ironMan.joinSquad(avengers);


        //homelander.joinSquad(avengers);


        System.out.println("Justice League Members:");
        for (Hero hero : justiceLeague.getHeroes()) {
            System.out.println(hero.getName());
        }

        System.out.println("\nAvengers Members:");
        for (Hero hero : avengers.getHeroes()) {
            System.out.println(hero.getName());
        }
        System.out.println();
        // Perform a battle between two squads
        justiceLeague.battle(avengers);
    }
}
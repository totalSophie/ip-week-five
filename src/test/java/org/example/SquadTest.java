package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquadTest {

    @Test
    public void testSquadAddHero() {
        Hero hero = new Hero("Iron Man", 35, "Powered Armor", "Arrogance");
        Squad squad = new Squad("Avengers", 4, "Protecting the World");
        hero.joinSquad(squad);

        squad.addHero(hero);

        assertEquals(squad, hero.getSquad());
        assertTrue(squad.getHeroes().contains(hero));
    }

    @Test
    public void testSquadRemoveHero() {
        Hero hero = new Hero("Captain America", 30, "Superhuman Strength", "Technology");
        Squad squad = new Squad("Avengers", 4, "Protecting the World");

        squad.addHero(hero);
        squad.removeHero(hero);

        assertNull(hero.getSquad());
        assertFalse(squad.getHeroes().contains(hero));
    }

    @Test
    public void testCalculateOverallScore() {
        Hero hero = new Hero("Test Hero", 25, "Test Power", "Test Weakness");
        int score = hero.calculateOverallScore();

        assertTrue(score >= 1 && score <= 10);
    }


}
package org.herosquad.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    @Test
    void testHeroJoinSquad() {
        Hero hero = new Hero("TestHero", 25, "TestPower", "TestWeakness");
        Squad squad = new Squad("TestSquad", 3, "TestCause");

        hero.joinSquad(squad);

        assertEquals(squad, hero.getSquad());
        assertTrue(squad.getHeroes().contains(hero));
    }

    @Test
    void testHeroLeaveSquad() {
        Hero hero = new Hero("TestHero", 25, "TestPower", "TestWeakness");
        Squad squad = new Squad("TestSquad", 3, "TestCause");

        hero.joinSquad(squad);
        hero.leaveSquad();

        assertNull(hero.getSquad());
        assertFalse(squad.getHeroes().contains(hero));
    }


}
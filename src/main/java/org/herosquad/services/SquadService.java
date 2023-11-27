package org.herosquad.services;

import org.herosquad.models.Hero;
import org.herosquad.models.Squad;

import java.util.ArrayList;
import java.util.List;

public class SquadService {
    private final List<Hero> heroes;
    private final List<Squad> squads;

    public SquadService() {
        this.heroes = new ArrayList<>();
        this.squads = new ArrayList<>();
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public List<Hero> getAllHeroes() {
        return new ArrayList<>(heroes);
    }
}

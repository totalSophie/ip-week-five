package org.herosquad.services;

import org.herosquad.models.Hero;
import org.herosquad.models.Squad;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public List<Hero> getAllHeroes() {
        return new ArrayList<>(heroes);
    }
    public List<Squad> getAllSquads() {
        return new ArrayList<>(squads);
    }

    public Squad getSquadById(int squadId) {
        return squads.stream()
                .filter(squad -> squad.getId() == squadId)
                .findFirst()
                .orElse(null);
    }

    public List<Hero> getHeroesNotInSquad(int squadId) {
        Squad squad = getSquadById(squadId);
        if (squad == null) {
            return new ArrayList<>();
        }

        return heroes.stream()
                .filter(hero -> !squad.getHeroes().contains(hero))
                .collect(Collectors.toList());
    }

    public void addHeroToSquad(int heroId, int squadId) {
        Hero hero = heroes.stream()
                .filter(h -> h.getId() == heroId)
                .findFirst()
                .orElse(null);

        Squad squad = getSquadById(squadId);

        if (hero != null && squad != null && squad.getHeroes().size() < squad.getMaxSize()) {
            squad.addHero(hero);
        }
    }

    public void removeHeroFromSquad(int heroId, int squadId) {
        Hero hero = heroes.stream()
                .filter(h -> h.getId() == heroId)
                .findFirst()
                .orElse(null);

        Squad squad = getSquadById(squadId);

        if (hero != null && squad != null) {
            squad.removeHero(hero);
        }
    }


}

package org.herosquad.controllers;

import org.herosquad.exceptions.InvalidInputException;
import org.herosquad.models.Hero;
import org.herosquad.services.SquadService;
import org.herosquad.utils.SparkUtils;
import spark.*;

import java.util.Map;

import static spark.Spark.*;

public class HeroController {
    private static SquadService squadService = null;

    public HeroController(final SquadService squadService) {
        this.squadService = squadService;
        setupRoutes();
    }

    private void setupRoutes() {
        get("/", (req, res) -> new ModelAndView(null, "home.ftl"), new SparkUtils.FreeMarkerTemplateEngine());

        path("/heroes", () -> {
            get("", listHeroes, new SparkUtils.FreeMarkerTemplateEngine());
            get("/new", newHeroForm, new SparkUtils.FreeMarkerTemplateEngine());
            post("/new", createHero);
        });

        // Other routes for squads, etc.
    }

    private static final TemplateViewRoute listHeroes = (req, res) -> {
        Map<String, Object> model = SparkUtils.createModel();
        model.put("heroes", squadService.getAllHeroes());
        return new ModelAndView(model, "hero-list.ftl");
    };

    private static final TemplateViewRoute newHeroForm = (req, res) -> new ModelAndView(null, "hero-form.ftl");

    private static final Route createHero = (Request req, Response res) -> {
        String name = req.queryParams("name");
        int age = Integer.parseInt(req.queryParams("age"));
        String power = req.queryParams("power");
        String weakness = req.queryParams("weakness");

        // Validate input
        if (name == null || power == null || weakness == null || name.isEmpty() || power.isEmpty() || weakness.isEmpty()) {
            throw new InvalidInputException("Name, power, and weakness cannot be empty");
        }

        Hero hero = new Hero(name, age, power, weakness);
        squadService.addHero(hero);

        res.redirect("/heroes");
        return null;
    };
}
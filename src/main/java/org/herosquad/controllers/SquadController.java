package org.herosquad.controllers;

import org.herosquad.exceptions.InvalidInputException;
import org.herosquad.models.Squad;
import org.herosquad.services.SquadService;
import org.herosquad.utils.SparkUtils;
import spark.*;

import java.util.Map;

import static spark.Spark.*;

public class SquadController {
    private static SquadService squadService = null;

    public SquadController(final SquadService squadService) {
        this.squadService = squadService;
        setupRoutes();
    }

    private void setupRoutes() {
        get("/", (req, res) -> new ModelAndView(null, "home.ftl"), new SparkUtils.FreeMarkerTemplateEngine());
        path("/squads", () -> {
            get("", listSquads, new SparkUtils.FreeMarkerTemplateEngine());
            get("/new", newSquadForm, new SparkUtils.FreeMarkerTemplateEngine());
            post("/new", createSquad);
            get("/:squadId", viewSquad, new SparkUtils.FreeMarkerTemplateEngine());
            post("/:squadId/add-hero", squadAddHero);
            post("/:squadId/remove-hero", squadRemoveHero);
            post("/:squadId/battle", squadBattle);
        });

        // ... (other routes)
    }

    private static final TemplateViewRoute listSquads = (req, res) -> {
        Map<String, Object> model = SparkUtils.createModel();
        model.put("squads", squadService.getAllSquads());
        return new ModelAndView(model, "squad-list.ftl");
    };

    private static final TemplateViewRoute newSquadForm = (req, res) -> new ModelAndView(null, "squad-form.ftl");

    private static final Route createSquad = (req, res) -> {
        String squadName = req.queryParams("squadName");
        String cause = req.queryParams("cause");
        int maxSize = Integer.parseInt(req.queryParams("maxSize"));

        // Validate input
        if (squadName == null || cause == null || squadName.isEmpty() || cause.isEmpty()) {
            throw new InvalidInputException("Squad name and cause cannot be empty");
        }

        Squad squad = new Squad(squadName, maxSize, cause);
        squadService.addSquad(squad);

        res.redirect("/squads");
        return null;
    };

    private static final TemplateViewRoute viewSquad = (req, res) -> {
        String squadId = req.params(":squadId");
        Squad squad = squadService.getSquadById(Integer.parseInt(squadId));

        Map<String, Object> model = SparkUtils.createModel();
        model.put("squad", squad);
        model.put("heroesNotInSquad", squadService.getHeroesNotInSquad(Integer.parseInt(squadId)));

        return new ModelAndView(model, "squad-view.ftl");
    };

    private static final Route squadAddHero = (req, res) -> {
        int squadId = Integer.parseInt(req.params(":squadId"));
        int heroId = Integer.parseInt(req.queryParams("heroId"));

        // Validate input
        if (heroId <= 0) {
            throw new InvalidInputException("Invalid Hero ID");
        }

        squadService.addHeroToSquad(heroId, squadId);

        res.redirect("/squads/" + squadId);
        return null;
    };

    private static final Route squadRemoveHero = (req, res) -> {
        int squadId = Integer.parseInt(req.params(":squadId"));
        int heroId = Integer.parseInt(req.queryParams("heroId"));

        // Validate input
        if (heroId <= 0) {
            throw new InvalidInputException("Invalid Hero ID");
        }

        squadService.removeHeroFromSquad(heroId, squadId);

        res.redirect("/squads/" + squadId);
        return null;
    };

    private static final Route squadBattle = (req, res) -> {
        int squadId = Integer.parseInt(req.params(":squadId"));
        int opponentId = Integer.parseInt(req.queryParams("opponentId"));

        // Validate input
        if (opponentId <= 0) {
            throw new InvalidInputException("Invalid Opponent Squad ID");
        }

        Squad thisSquad = squadService.getSquadById(squadId);
        Squad opponentSquad = squadService.getSquadById(opponentId);

        if (thisSquad == null || opponentSquad == null) {
            throw new Exception("Squad not found");
        }

        thisSquad.battle(opponentSquad);

        res.redirect("/squads/" + squadId);
        return null;
    };
}
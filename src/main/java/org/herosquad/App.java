package org.herosquad;

import org.herosquad.controllers.HeroController;
import org.herosquad.controllers.SquadController;
import org.herosquad.exceptions.InvalidInputException;
import org.herosquad.services.SquadService;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFiles.location("/public");

        // Set up routes
        new HeroController(new SquadService());
        new SquadController(new SquadService());

        // Exception handling
        exception(InvalidInputException.class, (e, req, res) -> {
            res.status(400);
            res.body("Bad Request: " + e.getMessage());
        });

        exception(Exception.class, (e, req, res) -> {
            res.status(500);
            res.body("Internal Server Error");
        });
    }
}

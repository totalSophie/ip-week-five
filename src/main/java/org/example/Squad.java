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
}

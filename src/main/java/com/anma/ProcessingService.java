package com.anma;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProcessingService {
    public Cat getCat() {
        return new Cat("Vasko", 3, "white");
    }
}

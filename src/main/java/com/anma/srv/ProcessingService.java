package com.anma.srv;

import com.anma.model.Cat;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProcessingService {
    public Cat getCat() {
        return new Cat("Vasko", 3, "white");
    }
}

package com.anma;

import com.anma.model.Cat;
import com.anma.srv.CatSyncService;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.Random;

@ApplicationScoped
public class Boot {
    private static final Logger LOG = LoggerFactory.getLogger(Boot.class);

    @Inject
    CatSyncService catSyncService;

    void onStart(@Observes StartupEvent event) {
        LOG.info(">>>>>>>>>>> starting");
//        for (int i = 0; i < 5; i++) {
//            Cat cat = new Cat();
//            cat.setName("Vasko");
//            cat.setAge(new Random().nextInt(5));
//            cat.setColor("white");
//            catSyncService.add(cat);
//        }
        Cat cat = new Cat();
        cat.setName("Vasko");
        cat.setAge(new Random().nextInt(5));
        cat.setColor("white");
        catSyncService.add(cat);
    }

    void onStop(@Observes ShutdownEvent event) {
        LOG.info(">>>>>>>>>>> stopping");
    }
}

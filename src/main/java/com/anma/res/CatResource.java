package com.anma.res;

import com.anma.model.Cat;
import com.anma.srv.CatSyncService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("cats")
public class CatResource {

    @Inject
    CatSyncService catService;

    @GET
    public List<Cat> getAll() {
        return catService.findAll();
    }

    @GET
    @Path("{name}")
    public Cat getSingle(String name) {
        return catService.get(name);
    }

    @POST
    public List<Cat> add(Cat fruit) {
        catService.add(fruit);
        return getAll();
    }

}

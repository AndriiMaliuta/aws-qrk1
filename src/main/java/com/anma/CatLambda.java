package com.anma;

import javax.inject.Inject;
import javax.inject.Named;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.anma.model.Cat;
import com.anma.model.InputObject;
import com.anma.srv.CatSyncService;
import com.anma.srv.ProcessingService;

@Named("cat")
public class CatLambda implements RequestHandler<InputObject, Cat> {
    @Inject
    ProcessingService service;
    @Inject
    CatSyncService catSyncService;

    @Override
    public Cat handleRequest(InputObject obj, Context context) {
        return catSyncService.get(obj.getName());
    }
}

package com.anma;

import javax.inject.Inject;
import javax.inject.Named;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

@Named("test")
public class TestLambda implements RequestHandler<InputObject, Cat> {

    @Inject
    ProcessingService service;

    @Override
    public Cat handleRequest(InputObject obj, Context context) {
        return service.getCat();
    }
}

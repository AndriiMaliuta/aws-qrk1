package com.anma.srv;

import com.anma.model.Cat;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CatSyncService extends AbstractService {
    @Inject
    DynamoDbClient dynamoDB;

    public List<Cat> findAll() {
        return dynamoDB.scanPaginator(scanRequest()).items().stream()
                .map(Cat::from)
                .collect(Collectors.toList());
    }

    public List<Cat> add(Cat cat) {
        dynamoDB.putItem(putRequest(cat));
        return findAll();
    }

    public Cat get(String name) {
        return Cat.from(dynamoDB.getItem(getRequest(name)).item());
    }
}

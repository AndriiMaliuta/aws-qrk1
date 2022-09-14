package com.anma.srv;

import com.anma.model.Cat;
import io.smallrye.mutiny.Uni;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CatAsyncService extends AbstractService {

    public static final Logger LOG = LoggerFactory.getLogger(CatAsyncService.class);
    @Inject
    DynamoDbAsyncClient dynamoDB;

    public Uni<List<Cat>> findAll() {
        return Uni.createFrom().completionStage(() -> dynamoDB.scan(scanRequest()))
                .onItem().transform(res -> res.items().stream().map(Cat::from).collect(Collectors.toList()));
    }

    public Uni<List<Cat>> add(Cat cat) {
        return Uni.createFrom().completionStage(() -> dynamoDB.putItem(putRequest(cat)))
                .onItem().ignore().andSwitchTo(this::findAll);
    }

    public Uni<Cat> get(String name) {
        return Uni.createFrom().completionStage(() -> dynamoDB.getItem(getRequest(name)))
                .onItem().transform(resp -> Cat.from(resp.item()));
    }
}

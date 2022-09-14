package com.anma.srv;

import java.util.HashMap;
import java.util.Map;

import com.anma.model.Cat;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;

public abstract class AbstractService {
    public final static String CAT_NAME_COL = "catName";
    public final static String CAT_AGE_COL = "catAge";
    public final static String CAT_COLOR_COL = "catColor";

    public String getTableName() {
        return "Cats1";
    }

    protected ScanRequest scanRequest() {
        return ScanRequest.builder().tableName(getTableName())
                .attributesToGet(CAT_NAME_COL).build();
    }

    protected PutItemRequest putRequest(Cat cat) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put(CAT_NAME_COL, AttributeValue.builder().s(cat.getName()).build());
        item.put(CAT_AGE_COL, AttributeValue.builder().s(String.valueOf(cat.getAge())).build());
        item.put(CAT_COLOR_COL, AttributeValue.builder().s(cat.getColor()).build());

        return PutItemRequest.builder()
                .tableName(getTableName())
                .item(item)
                .build();
    }

    protected GetItemRequest getRequest(String name) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put(CAT_NAME_COL, AttributeValue.builder().s(name).build());

        return GetItemRequest.builder()
                .tableName(getTableName())
                .key(key)
                .attributesToGet(CAT_NAME_COL)
                .build();
    }
}

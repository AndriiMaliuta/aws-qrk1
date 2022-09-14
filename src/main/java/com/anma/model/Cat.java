package com.anma.model;

//import com.amazonaws.services.lambda.runtime.events.models.dynamodb.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import com.anma.srv.AbstractService;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.Map;
import java.util.Objects;

@RegisterForReflection
public class Cat {
     String name;
     int age;
     String color;
    public Cat() {}

    public static Cat from(Map<String, AttributeValue> item) {
        Cat cat = new Cat();
        if (item != null && !item.isEmpty()) {
            cat.setName(item.get(AbstractService.CAT_NAME_COL).s());
            cat.setAge(Integer.parseInt(item.get(AbstractService.CAT_AGE_COL).s()));
            cat.setColor(item.get(AbstractService.CAT_COLOR_COL).s());
        }
        return cat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}

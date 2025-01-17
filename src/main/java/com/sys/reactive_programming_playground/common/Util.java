package com.sys.reactive_programming_playground.common;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Mono;

public class Util {

    private static final Faker faker = Faker.instance();

    public static <T> Subscriber<T> subscriber(){
        return new DefaultSubscriber<>("");
    }

    public static <T> Subscriber<T> subscriber(String name){
        return new DefaultSubscriber<>(name);
    }

    public static Faker faker(){
        return faker;
    }


}

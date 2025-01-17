package com.sys.reactive_programming_playground.sec02;

import com.sys.reactive_programming_playground.sec01.subscriber.SubscriberImpl;
import reactor.core.publisher.Mono;

public class Lec02MonoJust {

    public static void main(String[] args) {
        var mono = Mono.just("vins");
        var subscriber = new SubscriberImpl();
        mono.subscribe(subscriber);
        subscriber.getSubscription().request(10);
        subscriber.getSubscription().request(10);
        subscriber.getSubscription().cancel();
        System.out.println(mono);
    }
}

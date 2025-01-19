package com.sys.reactive_programming_playground.sec04;

import com.sys.reactive_programming_playground.common.Util;
import com.sys.reactive_programming_playground.sec01.subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateDownstreamDemand {

    private static final Logger log = LoggerFactory.getLogger(Lec04FluxCreateDownstreamDemand.class);

    public static void main(String[] args) {
        produceOnDemand();
    }

    private static void produceEarly(){
        var subscriber = new SubscriberImpl();

        Flux.<String>create(fluxSink -> {
            for(int i=0 ; i< 10 ; i++){
                var name = Util.faker().name().firstName();
                log.info("generated name : {}", name);
                fluxSink.next(name);
            }
            fluxSink.complete();
        }).subscribe(subscriber);

        Util.sleepSecond(2);
        subscriber.getSubscription().request(2);
        Util.sleepSecond(2);
        subscriber.getSubscription().request(2);
        Util.sleepSecond(5);
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(2);
    }

    private static void produceOnDemand(){
        var subscriber = new SubscriberImpl();

        Flux.<String>create(fluxSink -> {
            fluxSink.onRequest(request -> {
                for(int i=0 ; i< request && !fluxSink.isCancelled(); i++){
                    var name = Util.faker().name().firstName();
                    log.info("generated name : {}", name);
                    fluxSink.next(name);
                }
            });

        }).subscribe(subscriber);

        Util.sleepSecond(2);
        subscriber.getSubscription().request(2);
        Util.sleepSecond(2);
        subscriber.getSubscription().request(2);
        Util.sleepSecond(5);
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(2);
    }

}

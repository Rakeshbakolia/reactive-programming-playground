package com.sys.reactive_programming_playground.sec01.publisher;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {

    private static final Logger log = LoggerFactory.getLogger(SubscriptionImpl.class);
    private final Faker faker;
    private final Subscriber<? super String> subscriber;
    private boolean isCancelled;
    private static final int MAX_ITEMS = 10;
    private int count = 0;

    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
        this.faker = Faker.instance();
    }

    @Override
    public void request(long requests) {
        if (isCancelled) {
            return;
        }
        log.info("Subscriber has Requesting : {} items", requests);
        if(requests > MAX_ITEMS) {
            this.subscriber.onError(new RuntimeException("validation Failed"));
            this.isCancelled = true;
            return;
        }
        for (int i = 0; i < requests && count < MAX_ITEMS;  i++) {
            count++;
            subscriber.onNext(this.faker.internet().emailAddress());
        }
        if(count == MAX_ITEMS){
            log.info("No more data to produce");
            this.subscriber.onComplete();
            this.isCancelled = true;
        }
    }

    @Override
    public void cancel() {
        log.info("Subscription canceled");
        this.isCancelled = true;
    }
}

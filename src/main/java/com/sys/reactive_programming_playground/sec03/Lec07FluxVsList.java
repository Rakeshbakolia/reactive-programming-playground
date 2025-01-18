package com.sys.reactive_programming_playground.sec03;

import com.sys.reactive_programming_playground.common.Util;
import com.sys.reactive_programming_playground.sec01.subscriber.SubscriberImpl;
import com.sys.reactive_programming_playground.sec03.helper.NameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec07FluxVsList {

    private static final Logger log = LoggerFactory.getLogger(Lec07FluxVsList.class);

    public static void main(String[] args) {
//        var list = NameGenerator.getNamesList(10);
//        log.info("list: {}", list);

        var subscriber = new SubscriberImpl();
        NameGenerator.getNamesFlux(10).subscribe(subscriber);
        subscriber.getSubscription().request(3);
//      can cancel the request whenever I wanted
        subscriber.getSubscription().cancel();
    }
}

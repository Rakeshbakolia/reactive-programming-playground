package com.sys.reactive_programming_playground.sec03;

import com.sys.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;

public class Lec02MultipleSubscriber {

    public static void main(String[] args) {
        var flux = Flux.just(1,2,3,4,5,6,7,8);
        flux.subscribe(Util.subscriber("Subscriber 1"));
        flux.filter(item -> item > 7)
                .subscribe(Util.subscriber("Subscriber 2"));
        flux.filter(item -> item%2 ==0)
                .map(item -> item+"a")
                .subscribe(Util.subscriber("Subscriber 3"));

    }
}

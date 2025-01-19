package com.sys.reactive_programming_playground.sec04;

import com.sys.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;

/**
 * Take is similar to java stream's limit
 */
public class Lec05TakeOperator {

    public static void main(String[] args) {
        takeUtil();
    }

    private static void take(){
        Flux.range(1,10)
                .log("take log")
                .take(3)
                .log("subscribe log")
                .subscribe(Util.subscriber());
    }

    private static void takeWhile(){
        Flux.range(1,10)
                .log("take log")
                .takeWhile(i-> (i < 4)) // stop when condition is met also allow the last item
                .log("subscribe log")
                .subscribe(Util.subscriber());
    }

    private static void takeUtil(){
        Flux.range(1,10)
                .log("take log")
                .takeUntil(i-> (i > 4)) // stop when condition not met
                .log("subscribe log")
                .subscribe(Util.subscriber());
    }


}

package com.sys.reactive_programming_playground.sec03;

import com.sys.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {

    public static void main(String[] args) {
//      Its 3 to 12 not 10 (10 times starting form 3)
        Flux.range(3,10)
                .map( i -> Util.faker().name().firstName())
                .subscribe(Util.subscriber());
    }
}

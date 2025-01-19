package com.sys.reactive_programming_playground.sec04;

import com.sys.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;

public class Lec08FluxGenerateWithState {


//  can maintain last state of an object which is invoked only once
    public static void main(String[] args) {
        Flux.generate(
                () -> 0,
                (counter, synchronousSink) -> {
            var country = Util.faker().country().name();
            synchronousSink.next(country);
            counter++;
            if(counter == 10 || country.equalsIgnoreCase("canada")){
                synchronousSink.complete();
            }
            return counter;
        }).subscribe(Util.subscriber());
    }
}

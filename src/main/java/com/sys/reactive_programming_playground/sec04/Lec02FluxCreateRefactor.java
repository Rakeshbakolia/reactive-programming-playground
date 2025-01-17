package com.sys.reactive_programming_playground.sec04;

import com.sys.reactive_programming_playground.common.Util;
import com.sys.reactive_programming_playground.sec04.helper.NameGenerator;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactor {

    public static void main(String[] args) {
        var generator = new NameGenerator();
        var flux = Flux.create(generator);
        flux.subscribe(Util.subscriber("sub1"));
        // because flux is subscribed by multiple subscribers, last subscriber will only be able to see data
        flux.subscribe(Util.subscriber("sub2"));

        for(int i= 0 ; i< 10 ; i++){
            generator.generate();
        }
    }
}

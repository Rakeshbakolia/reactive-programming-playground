package com.sys.reactive_programming_playground.sec06;

import com.sys.reactive_programming_playground.common.Util;
import com.sys.reactive_programming_playground.sec04.helper.NameGenerator;
import reactor.core.publisher.Flux;

public class Lec05FluxCreateIssueFix {

    public static void main(String[] args) {
        var generator = new NameGenerator();
//      Making is hot publisher by calling share() so that both subscribers can get data
        var flux = Flux.create(generator).share();
        flux.subscribe(Util.subscriber("sub1"));
        flux.subscribe(Util.subscriber("sub2"));

        for(int i= 0 ; i< 10 ; i++){
            generator.generate();
        }
    }
}

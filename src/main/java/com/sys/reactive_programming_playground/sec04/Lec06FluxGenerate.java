package com.sys.reactive_programming_playground.sec04;

import com.sys.reactive_programming_playground.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec06FluxGenerate {

    private static final Logger log = LoggerFactory.getLogger(Lec06FluxGenerate.class);


    public static void main(String[] args) {

//      generate infinite time until we stop it
        Flux.generate(synchronousSink -> {
            log.info("invoked");
            synchronousSink.next(Util.faker().name().firstName());
        })
                .take(4)
                .subscribe(Util.subscriber());
    }
}

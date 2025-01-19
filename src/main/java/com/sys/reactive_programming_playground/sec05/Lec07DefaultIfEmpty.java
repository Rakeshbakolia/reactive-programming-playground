package com.sys.reactive_programming_playground.sec05;

import com.sys.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec07DefaultIfEmpty {

    public static void main(String[] args) {
        Mono.empty()
                .defaultIfEmpty("No data")
                .subscribe(Util.subscriber());
    }
}

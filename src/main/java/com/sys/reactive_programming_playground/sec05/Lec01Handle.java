package com.sys.reactive_programming_playground.sec05;

import com.sys.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;

/**
 * behave like filter + map
 */
public class Lec01Handle {

    public static void main(String[] args) {
        Flux<Integer> flux = Flux.range(1,10);
        flux.handle((item, sink) -> {
            switch (item){
                case 1 -> sink.next(-2);
                case 4 -> {}
                case 7 -> sink.error(new RuntimeException("Some error"));
                default -> sink.next(item);
            }
        })
                .cast(Integer.class)
                .subscribe(Util.subscriber());

    }
}

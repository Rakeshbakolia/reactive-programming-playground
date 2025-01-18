package com.sys.reactive_programming_playground.sec03;

import com.sys.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec03FluxFromIterableOrArray {

    public static void main(String[] args) {
        var list = List.of(1,2,3,4,5,6,7,8,9,10);
        Flux.fromIterable(list)
                .subscribe(Util.subscriber());

        Integer[] array = {1,2,3,4,5,6,7,8};
        Flux.fromArray(array)
                .subscribe(Util.subscriber());
    }
}

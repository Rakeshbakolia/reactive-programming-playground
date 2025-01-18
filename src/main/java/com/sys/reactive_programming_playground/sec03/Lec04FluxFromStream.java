package com.sys.reactive_programming_playground.sec03;

import com.sys.reactive_programming_playground.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec04FluxFromStream {

    public static void main(String[] args) {
        var list = List.of(1, 2, 3, 4);
        var stream = list.stream();
        var flux = Flux.fromStream(stream);

        flux.subscribe(Util.subscriber("subscribe-1"));
//      will get Error :- stream has already been operated upon or closed
        flux.subscribe(Util.subscriber("subscribe-2"));
//      To solve this pass supplier of stream

        var flux2 = Flux.fromStream(list::stream);
        flux2.subscribe(Util.subscriber("subscribe-3"));
        flux2.subscribe(Util.subscriber("subscribe-4"));

    }
}

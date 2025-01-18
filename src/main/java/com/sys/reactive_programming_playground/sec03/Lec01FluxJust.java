package com.sys.reactive_programming_playground.sec03;

import com.sys.reactive_programming_playground.common.Util;
import com.sys.reactive_programming_playground.sec02.Lac01LazyStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

public class Lec01FluxJust {

    public static void main(String[] args) {
        Flux.just(1,2,3,4,5,"rakesh",7,8,9,10)
                .subscribe(Util.subscriber());
    }
}

package com.sys.reactive_programming_playground.sec02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class Lac01LazyStream {

    private static final Logger log = LoggerFactory.getLogger(Lac01LazyStream.class);

    public static void main(String[] args) {
        // stream will not work until yo collect stream
        Stream.of(1)
                .peek(i -> log.info("received : {}", 1)).toList();
    }

}

package com.sys.reactive_programming_playground.sec02;

import com.sys.reactive_programming_playground.common.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyError {

    public static void main(String[] args) {
        getUserName(3).subscribe(Util.subscriber());
    }

    private static Mono<String> getUserName(int userId){
        return switch (userId){
            case 1 -> Mono.just("User1");
            case 2 -> Mono.empty(); // null
            default -> Mono.error(new RuntimeException("Invalid input"));
        };
    }
}

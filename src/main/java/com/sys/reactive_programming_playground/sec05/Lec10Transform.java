package com.sys.reactive_programming_playground.sec05;

import com.sys.reactive_programming_playground.common.Util;
import org.apache.commons.lang3.function.Functions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Lec10Transform {

    private static final Logger log = LoggerFactory.getLogger(Lec10Transform.class);


    record Customer(int id, String name){}
    record PurchaseOrder(String productName, int price, int quantity){}

    public static void main(String[] args) {

        var isDebuggerEnabled = true;

        getCustomers()
                .transform(isDebuggerEnabled ? addDebugger() : Function.identity() )
                .subscribe();

        isDebuggerEnabled = false;

        getPurchaseOrders()
                .transform(isDebuggerEnabled ? addDebugger() : Function.identity() )
                .subscribe();
    }

    private static <T> UnaryOperator<Flux<T>> addDebugger(){
        return flux -> flux
                .doOnNext(i -> log.info("received : {}",i))
                .doOnError(throwable -> log.error("error ",throwable))
                .doOnComplete(() -> log.info("completed "));
    }

    private static Flux<Customer> getCustomers(){
        return Flux.range(1,3)
                .map(i -> new Customer(i, Util.faker().name().firstName()));
    }

    private static Flux<PurchaseOrder> getPurchaseOrders(){
        return Flux.range(1,5)
                .map(i -> new PurchaseOrder(Util.faker().commerce().productName(), Util.faker().number().numberBetween(10,1000), Util.faker().number().numberBetween(1,10)));
    }

}

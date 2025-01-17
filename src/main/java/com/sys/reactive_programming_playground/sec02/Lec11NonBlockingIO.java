package com.sys.reactive_programming_playground.sec02;

import com.sys.reactive_programming_playground.common.Util;
import com.sys.reactive_programming_playground.sec02.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec11NonBlockingIO {

    private static final Logger log = LoggerFactory.getLogger(Lec11NonBlockingIO.class);

    public static void main(String[] args) {

        var client = new ExternalServiceClient();
        log.info("Start making http request");
//        Only 1 thread done all the work at the same time
        for(int i=1; i<=5;i++) {
            client.getProductName(i)
                    .subscribe(Util.subscriber());
        }

//        01:28:18.700 INFO  [           main] c.s.r.sec02.Lec11NonBlockingIO : Start making http request
//        01:28:19.847 INFO  [   rakesh-nio-1] c.s.r.common.DefaultSubscriber :  received : product-2
//        01:28:19.851 INFO  [   rakesh-nio-1] c.s.r.common.DefaultSubscriber :  received : product-4
//        01:28:19.852 INFO  [   rakesh-nio-1] c.s.r.common.DefaultSubscriber :  received : product-5
//        01:28:19.852 INFO  [   rakesh-nio-1] c.s.r.common.DefaultSubscriber :  received : product-3
//        01:28:19.853 INFO  [   rakesh-nio-1] c.s.r.common.DefaultSubscriber :  received : product-1

        Util.sleepSecond(2);
    }
}

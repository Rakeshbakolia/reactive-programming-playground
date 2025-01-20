package com.sys.reactive_programming_playground.sec03;

import com.sys.reactive_programming_playground.common.Util;
import com.sys.reactive_programming_playground.sec03.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec08NonBlockingStreamingMessages {

    private static final Logger log = LoggerFactory.getLogger(Lec08NonBlockingStreamingMessages.class);

    public static void main(String[] args) {
        var client = new ExternalServiceClient();
        client.getNames()
                .subscribe(Util.subscriber("subscriber-1"));

        client.getNames()
                .subscribe(Util.subscriber("subscriber-2"));

        Util.sleepSeconds(6);
    }
}

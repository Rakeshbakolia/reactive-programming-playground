package com.sys.reactive_programming_playground.sec05;

import com.sys.reactive_programming_playground.common.Util;
import com.sys.reactive_programming_playground.sec05.assignmnet.ExternalServiceClient;

public class Lec11Assignment {

    public static void main(String[] args) {
        var client = new ExternalServiceClient();

        for (int i = 0; i <5;i++){
            client.getProductName(i)
                    .subscribe(Util.subscriber());
        }

        Util.sleepSeconds(3);
    }
}

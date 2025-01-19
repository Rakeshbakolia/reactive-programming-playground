package com.sys.reactive_programming_playground.sec05.assignmnet;

import com.sys.reactive_programming_playground.common.AbstractHttpClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class ExternalServiceClient extends AbstractHttpClient {

    public Mono<String> getProductName(int productId){
        var defaultPath = "/demo03/product/"+productId;
        var timeoutPath = "/demo03/timeout-fallback/product/"+productId;
        var emptyPath = "/demo03/empty-fallback/product/"+productId;
        return getProductName(defaultPath)
                .timeout(Duration.ofSeconds(2), getProductName(timeoutPath))
                .switchIfEmpty(getProductName(emptyPath));
    }

    public Mono<String> getProductName(String path){
        return this.httpClient.get()
                .uri(path)
                .responseContent()
                .asString()
                .next();
    }
}

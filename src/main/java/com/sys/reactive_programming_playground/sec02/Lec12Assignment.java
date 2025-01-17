package com.sys.reactive_programming_playground.sec02;

import com.sys.reactive_programming_playground.common.Util;
import com.sys.reactive_programming_playground.sec02.assignment.FileServiceImpl;
import com.sys.reactive_programming_playground.sec02.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec12Assignment {

    private static final Logger log = LoggerFactory.getLogger(Lec11NonBlockingIO.class);

    public static void main(String[] args) {
        var fileService = new FileServiceImpl();
        fileService.write("file.txt", "This is test file").subscribe(Util.subscriber());
        fileService.read("file.txt").subscribe(Util.subscriber());
        fileService.delete("file.txt").subscribe(Util.subscriber());
    }
}

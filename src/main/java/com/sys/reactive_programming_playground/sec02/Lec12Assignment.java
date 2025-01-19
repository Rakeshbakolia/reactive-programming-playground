package com.sys.reactive_programming_playground.sec02;

import com.sys.reactive_programming_playground.common.Util;
import com.sys.reactive_programming_playground.sec02.assignment.FileServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec12Assignment {

    private static final Logger log = LoggerFactory.getLogger(Lec11NonBlockingIO.class);

    public static void main(String[] args) {
        var fileService = new FileServiceImpl();
        fileService.write("sec04/file.txt", "This is test file").subscribe(Util.subscriber());
        fileService.read("sec04/file.txt").subscribe(Util.subscriber());
        fileService.delete("sec04/file.txt").subscribe(Util.subscriber());
    }
}

package com.sys.reactive_programming_playground.sec04;

import com.sys.reactive_programming_playground.common.Util;
import com.sys.reactive_programming_playground.sec04.assignment.FileReaderService;
import com.sys.reactive_programming_playground.sec04.assignment.FileReaderServiceImpl;

import java.nio.file.Path;

public class Lec09Assignment {

    public static void main(String[] args) {
        var path = Path.of("src/main/resources/sec04/file.txt");
        var fileReaderService = new FileReaderServiceImpl();
        fileReaderService.read(path)
                .take(10)
                .subscribe(Util.subscriber("FileReaderSubscriber"));
    }
}

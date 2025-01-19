package com.sys.reactive_programming_playground.sec04.assignment;

import com.sys.reactive_programming_playground.sec04.Lec04FluxCreateDownstreamDemand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class FileReaderServiceImpl implements FileReaderService{

    private static final Logger log = LoggerFactory.getLogger(FileReaderServiceImpl.class);

    @Override
    public Flux<String> read(Path path) {
        return Flux.generate(
                () -> openFile(path),
                this::readFile,
                this::closeFile
        );
    }

    private BufferedReader openFile(Path path) throws IOException {
        log.info("Opening file");
        return Files.newBufferedReader(path);
    }

    private BufferedReader readFile(BufferedReader reader, SynchronousSink<String> sink) {
        try {
            String line = reader.readLine();
            log.info("Reading line : {}", line);
            if (Objects.isNull(line)) {
                sink.complete();
            } else {
                sink.next(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return reader;
    }

    private void closeFile(BufferedReader reader){
        try {
            reader.close();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

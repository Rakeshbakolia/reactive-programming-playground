package com.sys.reactive_programming_playground.sec02.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileServiceImpl implements FileService{

    private static final Logger log = LoggerFactory.getLogger(FileServiceImpl.class);
    private static final Path PATH = Path.of("src/main/resources/sec02");
    @Override
    public Mono<String> read(String filename) {
        return Mono.fromCallable(() -> Files.readString(PATH.resolve(filename)));
    }

    @Override
    public Mono<Void> write(String filename, String content) {
        return Mono.fromRunnable(() -> this.writeFile(filename, content));
    }

    @Override
    public Mono<Void> delete(String filename) {
        return Mono.fromRunnable(() -> this.deleteFile(filename));
    }

    private void writeFile(String filename, String content){
        try {
            Files.writeString(PATH.resolve(filename), content);
            log.info("File {} written successfully", filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteFile(String filename){
        try {
            Files.deleteIfExists(PATH.resolve(filename));
            log.info("File {} deleted successfully", filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

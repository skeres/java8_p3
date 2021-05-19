package com.sks.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WriteReadFilewithStream {

    public void doStuff() {

    }

    public void writeFile(){
        System.out.println("creation du fichier");
        List<String> myDataList= Arrays.asList("line 1 ","line 2 ", "line 3");
        Path testPath= Paths.get("/home/stephane/beautifulFile.txt");

        if (! Files.notExists(testPath) ) {
            try {
                Files.delete(testPath);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        final Path path= Paths.get("/home/stephane/beautifulFile.txt");
        if (Files.notExists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            myDataList.stream().forEach(e-> {
                try {
                    System.out.println("vu "+e);
                    Files.write(path, e.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND );
                    Files.write(path, "\n".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND );
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });


    }


    public void readFile(){
        System.out.println("lecture du fichier");
        Path path= Paths.get("/home/stephane/beautifulFile.txt");
        try {
            Files.lines(path,Charset.forName("UTF-8")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

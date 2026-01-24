package org.example.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Data {
    private List<String> wordleList;

    public List<String> getListWord() {
        if (wordleList == null) {
            try {
                wordleList = Files.readAllLines(Paths.get("Wordle.txt"));
                return wordleList;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return wordleList;
    }
}

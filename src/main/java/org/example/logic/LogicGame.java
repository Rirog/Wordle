package org.example.logic;

import org.example.data.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class LogicGame {
    private final Data data;

    public LogicGame(Data data) {
        this.data = data;
    }


    public String getRandomWord() {
        List<String> listWord = data.getListWord();
        return listWord.get(new Random().nextInt(listWord.size()));
    }

    public List<String> checkWord(String word, String secretWord) {
        List<String> listWord = data.getListWord();
        List<String> responseChecks = new ArrayList<>();

        if (word.length() != 5 ) {
            throw new RuntimeException("The word must consist of 5 letters.");
        }

        if (listWord.stream().noneMatch(x -> x.equalsIgnoreCase(word))) {
            throw new RuntimeException("The word is missing from the dictionary");
        }

        if (secretWord.equalsIgnoreCase(word)) {
            responseChecks.add("Win!");
        } else {
            for (int i = 0; i < word.length(); i++) {
                if (secretWord.charAt(i) == word.charAt(i)) {
                    responseChecks.add(word.charAt(i) + " - the letter is correct and in its place");
                } else if (secretWord.indexOf(i) != -1) {
                    responseChecks.add(word.charAt(i) + " - the letter is correct, but not in its place.");
                } else responseChecks.add(word.charAt(i) + " - the letter is missing from the word");
            }
        }
        return responseChecks;
    }
}


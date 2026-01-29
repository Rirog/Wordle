package org.example.service;

import org.example.exception.WordNotFoundException;
import org.example.exception.WordNotMeetException;
import org.example.constant.ResponseCheck;
import org.example.data.Data;
import org.example.model.Word;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class WordServiceImpl{
    private final Data data;


    public WordServiceImpl(Data data) {
        this.data = data;
    }

    public String getRandomWord() {
        List<String> listWord = data.getListWord();
        return listWord.get(new Random().nextInt(listWord.size()));
    }

    public List<String> checkWord(Word word, Word secretWord) {
        if (word.wordLength() != 5) {
            throw new WordNotMeetException();
        }

        List<String> listWord = data.getListWord();
        List<String> responseChecks = new ArrayList<>();

        if (listWord.stream().noneMatch(x -> x.equalsIgnoreCase(word.getWord()))) {
            throw new WordNotFoundException();
        }

        if (secretWord.equals(word)) {
            responseChecks.add(ResponseCheck.WIN.getMessageCheck());
        } else {
            for (int i = 0; i < word.wordLength(); i++) {
                char currentChar = word.getWord().charAt(i);
                if (secretWord.getWord().charAt(i) == currentChar) {
                    responseChecks.add(currentChar + ResponseCheck.CORRECT.getMessageCheck());
                } else if (secretWord.getWord().indexOf(currentChar) != -1) {
                    responseChecks.add(currentChar + ResponseCheck.NEARLY.getMessageCheck());
                } else responseChecks.add(currentChar + ResponseCheck.ABSENT.getMessageCheck());
            }
        }
        return responseChecks;
    }
}

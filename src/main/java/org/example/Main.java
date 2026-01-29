package org.example;

import org.example.data.Data;
import org.example.service.WordServiceImpl;
import org.example.service.GameController;
import org.example.ui.InputWord;
import org.example.ui.UserInterface;

public class Main {
    public static void main(String[] args) {

        Data data = new Data();
        WordServiceImpl wordService = new WordServiceImpl(data);

        InputWord inputWord = new InputWord();
        UserInterface userInterface = new UserInterface();

        GameController gameController = new GameController(inputWord, userInterface, wordService);
        gameController.startGame();
    }
}
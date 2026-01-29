package org.example.service;

import org.example.model.Word;
import org.example.ui.InputWord;
import org.example.ui.UserInterface;

import java.util.List;

public class GameController {
    private final InputWord inputWord;
    private final UserInterface userInterface;
    private final WordServiceImpl wordService;


    public GameController(InputWord inputWord,UserInterface userInterface, WordServiceImpl wordService) {
        this.inputWord = inputWord;
        this.userInterface = userInterface;
        this.wordService = wordService;
    }

    public void startGame() {
        boolean roleRunning = true;
        while (roleRunning) {
            userInterface.getMenu();
            int choice = inputWord.readMenuChoice();
            switch (choice) {
                case 1 -> playGame();
                case 0 -> roleRunning = false;
                default -> userInterface.invalidInputChoice();
            }
        }
        inputWord.close();
    }

    private void playGame() {
        Word secretWord = new Word(wordService.getRandomWord());
        for (int attempt = 0; attempt < 6; attempt++) {
            userInterface.showRules();
            Word word = inputWord.readWord();
            try {
                List<String> listResponse = wordService.checkWord(word, secretWord);
                if (listResponse.size() == 1 && listResponse.get(0).equals("Win!")) {
                    userInterface.showResults(listResponse);
                    break;
                }
                userInterface.showResults(listResponse);

            } catch (RuntimeException e) {
                userInterface.showError(e.getMessage());
                attempt--;
            }
            if (attempt == 5) {
                userInterface.showGameOver(secretWord.getWord());
            }
        }
    }
}

package org.example.ui;

import org.example.model.Word;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private final static String menu = """
            \nWordle
            Guess a 5 letter word in 6 attempts
            1 - start game;
            0 - exit.""";


    private final static String textRules = "\nWrite a word consisting of 5 letters";
    private final static String textEndGame = "\nYou guessed wrong. The secret word: ";
    private final static String invalidInputMessage = "Invalid input. Please enter a number (1 or 0).";


    public void getMenu() {
        responseMessage(menu);
    }

    public void invalidInputChoice() {
        responseMessage(invalidInputMessage);
    }

    public void showRules() {
        responseMessage(textRules);
    }

    public void showResults(List<String> listRes) {
        listRes.forEach(x -> responseMessage(x)); //It highlights
    }

    public void showGameOver(String secretWord) {
        responseMessage(textEndGame + secretWord);
    }

    public void showError(String error) {
        responseMessage(error);
    }


    public void responseMessage(String message) {
        System.out.println(message);
    }
}

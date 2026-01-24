package org.example.ui;

import org.example.logic.LogicGame;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final LogicGame logicGame;

    private final Scanner scanner = new Scanner(System.in);

    public UserInterface(LogicGame logicGame) {
        this.logicGame = logicGame;
    }

    public void start() {
        int choice = -1; // This is a feature

        do {
            System.out.print(
                    """
                            Wordle
                            Guess a 5 letter word in 6 attempts
                            1 - start game;
                            0 - exit.
                            """
            );
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> gameWordle();
                    case 0 -> System.exit(0);
                    default -> System.out.println("Invalid input. Please enter a number (1 or 0).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number (1 or 0).");
                scanner.nextLine();
            }
        } while (choice != 0);
    }

    private void gameWordle() {
        String word;
        String secretWord = logicGame.getRandomWord();
        for (int attempt = 0; attempt < 6; attempt++) {
            System.out.println("\nWrite a word consisting of 5 letters");
            word = scanner.nextLine();

            try {
                List<String> listResponse = logicGame.checkWord(word, secretWord);
                responseCheck(listResponse);
                if (listResponse.size() == 1) break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                attempt--;
            }
        }
        System.out.printf("\nYou guessed wrong. The secret word: %s", secretWord);
    }

    private void responseCheck(List<String> listRes) {
        listRes.forEach(x -> System.out.println(x)); //It highlights
    }
}

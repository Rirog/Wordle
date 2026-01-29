package org.example.ui;

import org.example.model.Word;

import java.util.Scanner;

public class InputWord {
    private final Scanner scanner = new Scanner(System.in);

    public int readMenuChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

    public Word readWord() {
        String input = scanner.nextLine().trim();
        return new Word(input);
    }

    public void close() {
        scanner.close();
    }

}

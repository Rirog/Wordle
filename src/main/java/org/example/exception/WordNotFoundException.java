package org.example.exception;

public class WordNotFoundException extends RuntimeException {
    public WordNotFoundException() {
        super("The word is missing from the dictionary");
    }
}

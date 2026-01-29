package org.example.exception;

public class WordNotMeetException extends RuntimeException {
    public WordNotMeetException() {
        super("The word must consist of 5 letters");
    }
}

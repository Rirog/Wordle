package org.example.constant;

public enum ResponseCheck {
    CORRECT(" - the letter is correct and in its place"),
    NEARLY(" - the letter is correct, but not in its place."),
    ABSENT(" - the letter is missing from the word"),
    WIN("Win!");

    private final String answer;

    ResponseCheck(String answer) {
        this.answer = answer;
    }

    public String getMessageCheck(){
        return answer;
    }
}

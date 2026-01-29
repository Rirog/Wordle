package org.example.model;

import java.util.Objects;

public class Word {
    private final String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public int wordLength(){
        return word.length();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return word1.getWord().equalsIgnoreCase(this.word);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(word);
    }
}

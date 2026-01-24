package org.example;


import org.example.logic.LogicGame;
import org.example.data.Data;
import org.example.ui.UserInterface;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface(
                new LogicGame(
                        new Data()
                )
        );
        userInterface.start();
    }
}
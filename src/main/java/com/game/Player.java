package com.game;

import java.util.Random;
import java.util.Scanner;

public class Player {
    
    private char symbol;
    private Scanner scanner;
    private Random random = new Random();

    public Player(char symbol, Scanner scanner) {
        this.symbol = symbol;
        this.scanner = scanner;
    }

    
    public Player(char symbol) {
        this.symbol = symbol;
    }
}
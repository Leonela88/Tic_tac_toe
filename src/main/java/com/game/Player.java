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

    public void play(Board board) { 
        int move;
        While (true){
          System.out.println("Elige posicion (1-9):");  
          move = Integer.parseInt(scanner.nextLine());
          if (board.isValidMove(move)) break;
          System.out.println("Casilla ocupada");
        }
        board.placeMove(move, symbol);
        }

    public void playRandom(Board board) {
        int move;
        do {
            move = random.nextInt(9) + 1;
        } while (!board.isValidMove(move));
        System.out.println("Eleccion computadora " + move);
        board.placeMove(move, symbol);
    }
}
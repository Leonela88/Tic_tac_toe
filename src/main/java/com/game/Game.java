package com.game;

import java.util.Scanner;

public class Game {
    private Board board;
    private Player player;
    private Player computer;
    private Scanner scanner;

    public Game() {
        board = new Board();
        scanner = new Scanner(System.in);
        player = new Player('X', scanner);
        computer = new Player('O');
    }

    public void start() {
        board.print();

        while (true) {
            player.play(board);
            if (board.isGameFinished('X'))
                break;
            board.print();

            computer.playRandom(board);
            if (board.isGameFinished('O'))
                break;
            board.print();
        }

        scanner.close();
    }

}
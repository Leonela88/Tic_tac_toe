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

    public void instructionsGame() {
        System.out.println("¡Bienvenido a Tic-Tac-Toe!");
        System.out.println("¿Preparado para comenzar?");
        System.out.println(
                "Jugarás con la X y como primer paso tendrás que elegir la posición en la que jugarás, desde la posición 1 a la 9");
        System.out.println("Ganarás si logras tener tres cruces consecutivas en horizontal, vertical o diagonal");
    }

    public void start() {
        instructionsGame();
        board.print();
        while (true) {
            player.play(board);
            if (board.isGameFinished('X'))
                break;
            board.print();

            System.out.println("Turno de 'O'");
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            computer.playRandom(board);
            if (board.isGameFinished('O'))
                break;
            board.print();
        }

        scanner.close();
    }

}
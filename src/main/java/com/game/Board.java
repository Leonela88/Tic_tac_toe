package com.game;
public class Board {
   
    private char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    public void print() { 
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }

       public boolean isValidMove(int pos) { 
        int row = (pos - 1) / 3;
        int col = (pos - 1) % 3;
        return board[row][col] == ' ';
    }

    public void placeMove(int pos, char symbol) {
        int row = (pos - 1) / 3;
        int col = (pos - 1) % 3;
        board[row][col] = symbol;
    }
}
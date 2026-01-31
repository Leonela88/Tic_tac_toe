package com.game;

public class Board {

    private char[][] board = {
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' }
    };

    public void print() {
        String pad = "        ";

        System.out.println(pad + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println(pad + "-+-+-");
        System.out.println(pad + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println(pad + "-+-+-");
        System.out.println(pad + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
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

    public boolean isGameFinished(char symbol) {
        if (hasWon(symbol)) {
            print();
            System.out.println(symbol + " Has ganado, Felicidades!!!");
            return true;
        }
        for (char[] row : board) {
            for (char c : row) {
                if (c == ' ')
                    return false;
            }
        }
        print();
        System.out.println("Es un empate!");
        return true;
    }

    private boolean hasWon(char s) {
        return  (board[0][0] == s && board[0][1] == s && board[0][2] == s) ||
                (board[1][0] == s && board[1][1] == s && board[1][2] == s) ||
                (board[2][0] == s && board[2][1] == s && board[2][2] == s) ||
                (board[0][0] == s && board[1][0] == s && board[2][0] == s) ||
                (board[0][1] == s && board[1][1] == s && board[2][1] == s) ||
                (board[0][2] == s && board[1][2] == s && board[2][2] == s) ||
                (board[0][0] == s && board[1][1] == s && board[2][2] == s) ||
                (board[0][2] == s && board[1][1] == s && board[2][0] == s);
    }
}
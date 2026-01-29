package com.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void tableroNuevo_todasLasPosicionesSonValidas() {
        Board board = new Board();

        for (int pos = 1; pos <= 9; pos++) {
            assertTrue(board.isValidMove(pos), "La posición " + pos + " debería estar libre");
        }
    }

    @Test
    void placeMove_ocupaLaCasilla_yYaNoEsMovimientoValido() {
        Board board = new Board();

        board.placeMove(5, 'X');

        assertFalse(board.isValidMove(5), "La posición 5 debería estar ocupada");
        assertTrue(board.isValidMove(1), "Otra posición debería seguir libre");
    }

    @Test
    void victoriaPorFila_isGameFinishedDevuelveTrue() {
        Board board = new Board();

        board.placeMove(1, 'X');
        board.placeMove(2, 'X');
        board.placeMove(3, 'X');

        assertTrue(board.isGameFinished('X'));
    }

    @Test
    void victoriaPorColumna_isGameFinishedDevuelveTrue() {
        Board board = new Board();

        board.placeMove(1, 'O');
        board.placeMove(4, 'O');
        board.placeMove(7, 'O');

        assertTrue(board.isGameFinished('O'));
    }

    @Test
    void victoriaDiagonalPrincipal_isGameFinishedDevuelveTrue() {
        Board board = new Board();

        board.placeMove(1, 'X');
        board.placeMove(5, 'X');
        board.placeMove(9, 'X');

        assertTrue(board.isGameFinished('X'));
    }

    @Test
    void victoriaDiagonalSecundaria_isGameFinishedDevuelveTrue() {
        Board board = new Board();

        board.placeMove(3, 'O');
        board.placeMove(5, 'O');
        board.placeMove(7, 'O');

        assertTrue(board.isGameFinished('O'));
    }

    @Test
    void empate_tableroLlenoSinGanador_isGameFinishedDevuelveTrue() {
        Board board = new Board();

        // Empate típico (ninguna línea completa)
        // X O X
        // X O O
        // O X X
        board.placeMove(1, 'X');
        board.placeMove(2, 'O');
        board.placeMove(3, 'X');
        board.placeMove(4, 'X');
        board.placeMove(5, 'O');
        board.placeMove(6, 'O');
        board.placeMove(7, 'O');
        board.placeMove(8, 'X');
        board.placeMove(9, 'X');

        assertTrue(board.isGameFinished('X'));
        assertTrue(board.isGameFinished('O'));
    }

    @Test
    void juegoNoTerminado_tableroNoLlenoYSinGanador_isGameFinishedDevuelveFalse() {
        Board board = new Board();

        board.placeMove(1, 'X');
        board.placeMove(2, 'O');

        assertFalse(board.isGameFinished('X'));
        assertFalse(board.isGameFinished('O'));
    }
}
/*
    Nicolas Queijo
    PID: 5152398
    Assignment 3
    COP3337 - U04
    T/R 2:00 PM - 3:15 PM
    William Feild
    I hereby certify that this collective work is my own and none of it is the work of any other person or entity. 

    To compile and execute in FIU SCIS:
        > Have files somewhere in your buffalo server
        > Navigate to directory where files is stored using cd and ls to guide you
        > Compile using javac Tester.java TicTacToe.java
        > Execute using java Tester

    PURPOSE:
        This class holds the blueprint of a TicTacToe object. It provides a constructor,
        fields, and methods appropriate to build and use a TicTacToe object.
 */
package cop3337_assignment3_nq;

public class TicTacToe {

    public static final char PLAYER_1 = 'X';
    public static final char PLAYER_2 = 'O';
    public static final int MAX_ROWS = 3;
    public static final int MAX_COLS = 3;
    public static final int MAX_CELLS = MAX_ROWS * MAX_COLS;

    private char winner = ' ';
    private final int OFF_BY_1 = 1;
    private final boolean[] OCCUPIED_CELLS = {false, false, false, false, false, false, false, false, false};
    private final char[][] BOARD = new char[][]{
        {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '},
        {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
        {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '},
        {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
        {' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' '}
    };
    public static final char[][] SAMPLE_BOARD = new char[][]{
        {' ', '7', ' ', '|', ' ', '8', ' ', '|', ' ', '9', ' '},
        {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
        {' ', '4', ' ', '|', ' ', '5', ' ', '|', ' ', '6', ' '},
        {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
        {' ', '1', ' ', '|', ' ', '2', ' ', '|', ' ', '3', ' '}
    };

    // Empty constructor
    public TicTacToe() {
    }

    // Displays the sample board as a guide which resembles the numeric keypad
    public static void printSample() {
        System.out.println("\nSAMPLE BOARD:\n");
        for (int row = 0; row < SAMPLE_BOARD.length; row++) {
            for (int col = 0; col < SAMPLE_BOARD[row].length; col++) {
                System.out.print(SAMPLE_BOARD[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // Displays the actual game board being played
    public void printBoard() {
        System.out.println("YOUR BOARD:\n");
        for (int row = 0; row < BOARD.length; row++) {
            for (int col = 0; col < BOARD[row].length; col++) {
                System.out.print(BOARD[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // Checks all possible winning combinations (3 horizontal, 3 vertical, 2 diagonal)
    // and updates the winner if a winning case occurs
    // @param player: Player 1 (X) or Player 2 (O)
    public void checkWinner(char player) {
        if (BOARD[0][1] == player && BOARD[0][5] == player && BOARD[0][9] == player) {
            winner = player;
        } else if (BOARD[2][1] == player && BOARD[2][5] == player && BOARD[2][9] == player) {
            winner = player;
        } else if (BOARD[4][1] == player && BOARD[4][5] == player && BOARD[4][9] == player) {
            winner = player;
        } else if (BOARD[0][1] == player && BOARD[2][1] == player && BOARD[4][1] == player) {
            winner = player;
        } else if (BOARD[0][5] == player && BOARD[2][5] == player && BOARD[4][5] == player) {
            winner = player;
        } else if (BOARD[0][9] == player && BOARD[2][9] == player && BOARD[4][9] == player) {
            winner = player;
        } else if (BOARD[0][1] == player && BOARD[2][5] == player && BOARD[4][9] == player) {
            winner = player;
        } else if (BOARD[4][1] == player && BOARD[2][5] == player && BOARD[0][9] == player) {
            winner = player;
        }
    }

    // Sets the move the player performed to the corresponding cell on the board
    // Also flags that cell on the board as occupied to restrict overwrite
    // @param player: Player 1 (X) or Player 2 (O)
    // @param move: 1 of 9 possible options on board
    public void setMove(char player, int move) {
        if (move == 1) {
            BOARD[4][1] = player;
            OCCUPIED_CELLS[move - OFF_BY_1] = true;
        } else if (move == 2) {
            BOARD[4][5] = player;
            OCCUPIED_CELLS[move - OFF_BY_1] = true;
        } else if (move == 3) {
            BOARD[4][9] = player;
            OCCUPIED_CELLS[move - OFF_BY_1] = true;
        } else if (move == 4) {
            BOARD[2][1] = player;
            OCCUPIED_CELLS[move - OFF_BY_1] = true;
        } else if (move == 5) {
            BOARD[2][5] = player;
            OCCUPIED_CELLS[move - OFF_BY_1] = true;
        } else if (move == 6) {
            BOARD[2][9] = player;
            OCCUPIED_CELLS[move - OFF_BY_1] = true;
        } else if (move == 7) {
            BOARD[0][1] = player;
            OCCUPIED_CELLS[move - OFF_BY_1] = true;
        } else if (move == 8) {
            BOARD[0][5] = player;
            OCCUPIED_CELLS[move - OFF_BY_1] = true;
        } else if (move == 9) {
            BOARD[0][9] = player;
            OCCUPIED_CELLS[move - OFF_BY_1] = true;
        }
    }

    // Returns the winner of the game if any
    // @return winner: winner of the game (Player 1 or 2)
    public char getWinner() {
        return winner;
    }

    // Returns the array that flags occupancy status of cells
    // @return OCCUPIED_CELLS: list of cells that are occupied
    public boolean[] getOccupiedCells() {
        return OCCUPIED_CELLS;
    }

}

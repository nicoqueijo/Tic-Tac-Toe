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
        This class creates an instance of a TicTacToe object in the main method
        and allows the user to play until there's a winner or the match is a draw.
 */
package cop3337_assignment3_nq; // comment this out

// Used to get user input from the keyboard
import java.util.Scanner;

public class TicTacToeTester {

    public static void main(String[] args) {

        final int ODD = 1;
        final int MIN_VALID_MOVE = 1;
        final int MAX_VALID_MOVE = 9;
        Scanner input = new Scanner(System.in);
        int move = 0;
        int turnCount = 0;
        introMessage();
        instructionsMessage();
        TicTacToe.printSample();
        startMessage();
        input.nextLine();
        TicTacToe ttt = new TicTacToe();

        // Prompts execute as long as the game isn't over or inputs are invalid
        // forumla: (turnCount % 2 + 1) determines alternation between turns
        while (ttt.getWinner() == ' ' && turnCount < TicTacToe.MAX_CELLS) {
            System.out.print("Player " + (turnCount % 2 + 1) + ", please enter a move (1-9): ");
            while (!input.hasNextInt()) {
                invalidInput();
                input.next();
            }
            move = input.nextInt();
            while ((move < MIN_VALID_MOVE || move > MAX_VALID_MOVE) || (ttt.getOccupiedCells()[move - 1])) {
                invalidInput();
                if (input.hasNextInt()) {
                    move = input.nextInt();
                } else {
                    input.next();
                }
            }
            if ((turnCount % 2 + 1) == ODD) {
                ttt.setMove('X', move);
            } else {
                ttt.setMove('O', move);
            }
            turnCount++;
            TicTacToe.printSample();
            ttt.printBoard();
            ttt.checkWinner(TicTacToe.PLAYER_1);
            ttt.checkWinner(TicTacToe.PLAYER_2);
        }

        resultMessage(ttt.getWinner());
    }

    // Displays introductory message describing the objective of the game and the rules.
    public static void introMessage() {
        System.out.println("Welcome to the game of Tic Tac Toe!");
        System.out.println("The objective of Tic Tac Toe is to get three in a row. You play on a three \n"
                + "by three game board. The first player is known as X and the second is O. Players \n"
                + "alternate placing Xs and Os on the game board until either opponent has three in a \n"
                + "row or all nine cells are filled. X always goes first, and in the event that no \n"
                + "one has three in a row the result is a draw. \n");
    }

    // Displays message notifying the user that the previous move was invalid
    public static void invalidInput() {
        System.out.print("Invalid input. ");
        System.out.print("Please enter a valid move: ");
    }

    // Displays the result of the match at the end of the game
    // @param winner: Player 1 (X) or Player 2 (O)
    public static void resultMessage(char winner) {
        if (winner == TicTacToe.PLAYER_1) {
            System.out.println("Player 1 has won!");
        } else if (winner == TicTacToe.PLAYER_2) {
            System.out.println("Player 2 has won!");
        } else {
            System.out.println("Match is a draw!");
        }
    }

    // Displays message regarding input validation
    public static void instructionsMessage() {
        System.out.println("Each player must enter their move in the available cells 1 through 9 as shown \n"
                + "below (think your numeric keypad). Players cannot enter a move outside the range \n"
                + "and cannot overwrite an occupied cell. \n");
    }

    // Displays message instructing the user how to start the game
    public static void startMessage() {
        System.out.println("\nPress the ENTER key to begin playing. Good luck! \n");
    }

}

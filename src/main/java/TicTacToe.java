import java.util.*;

public class TicTacToe {
    static String[] board;
    static String turn;

    //Check the winners to keep playing the games or announce the winners - method
    static String CheckWinners() {
        //Check different cases for winning
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0: line = board[0] + board[1] + board[2]; break;
                case 1: line = board[3] + board[4] + board[5]; break;
                case 2: line = board[6] + board[7] + board[8]; break;
                case 3: line = board[0] + board[3] + board[6]; break;
                case 4: line = board[1] + board[4] + board[7]; break;
                case 5: line = board[2] + board[5] + board[8]; break;
                case 6: line = board[0] + board[4] + board[8]; break;
                case 7: line = board[2] + board[4] + board[6]; break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "X";
            }
            //For O winner
            else if (line.equals("OOO")) {
                return "O";
            }
        }
        //Check if there are any empty slot left to continue the game
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(String.valueOf(a+1))) {
                break;
            }
            //The match result is draw
            else if (a == 8) {
                return "draw";
            }
        }
        //Print the next instruction on the screen
        System.out.println(turn + "'s turn: Enter the slot number to put the " + turn + " in");
        return null;
    }

    //Print the board to the screen - method
    static void Printboard() {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }

    //Start the program
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String winner = null;
        turn = "X";
        board = new String[9];
        //Draw the board
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }

        //Instructions
        System.out.println("Welcome to TikTacToe");
        Printboard();
        System.out.println("X player will start first.");
        System.out.println("Please enter the slot number to mark on the board:");

        //While playing
        while (winner == null) {
            int InputNum;
            //Try-catch the value of slot number
            try {
                InputNum = scan.nextInt();
                if (!(InputNum > 0 && InputNum <= 9)) {
                    System.out.println("Invalid slot number");
                    System.out.println("Please try another number from 1 to 9:");
                    continue;
                }
            } catch (InputMismatchException e) {
                continue;
            }

            if (board[InputNum - 1].equals(
                    String.valueOf(InputNum))) {
                board[InputNum - 1] = turn;
                if (turn.equals("X")) {
                    turn = "O";
                } else {
                    turn = "X";
                }
                Printboard();
                winner = CheckWinners();
            } else {
                System.out.println("Occupied slot, please try another slot:");
            }
        }

            if (winner.equals("draw")) {
                System.out.println("This match is draw.");
            }
            else {
                System.out.println("Congratulations! " + winner + " is the winner");
            }
        }
    }

// TicTacToe.java

import java.util.Scanner;

public class TicTacToe {
    
    // Game board
    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    // Current player
    static char currentPlayer = 'X';

    // Function to create Tic-Tac-Toe game
    public static void main(String[] args){
        // Create scanner class object to read input
        try(Scanner sc = new Scanner(System.in)){

            boolean gameOver = false;
            int moves = 0;

            while(!gameOver){
                printBoard();

                // Get player input
                System.out.println("Player " + currentPlayer + ", enter row (1-3) and column (1-3): ");
                System.out.print("Row: ");
                int row = sc.nextInt() - 1;
                System.out.print("Col: ");
                int col = sc.nextInt() - 1;

                // Validate move
                if(row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' '){
                    System.out.println("Invalid move. Try again.");
                    continue;
                }

                // Make move
                board[row][col] = currentPlayer;
                moves++;

                // Check win condition
                if(checkWin()){
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOver = true;
                } else if(moves == 9){
                    printBoard();
                    System.out.println("It's a draw!");
                    gameOver = true;
                } else{
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }
        } catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    // Print game board
    static void printBoard(){
        System.out.print("    1   2   3");
        System.out.println("\n  -------------");
        for(int i = 0; i < 3; i++){
            System.out.print((i+1) + " | ");
            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n  -------------");
        }
    }

    // Check win
    static boolean checkWin(){
        // Check rows & columns
        for(int i = 0; i < 3; i++){
            if(board[i][0] == currentPlayer &&
                board[i][1] == currentPlayer &&
                board[i][2] == currentPlayer) return true;

            if(board[0][i] == currentPlayer &&
                board[1][i] == currentPlayer &&
                board[2][i] == currentPlayer) return true;        
        }

        // Check diagonals
        if(board[0][0] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][2] == currentPlayer) return true;
        
        return(board[0][2] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][0] == currentPlayer);
    }
}
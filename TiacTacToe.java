import java.util.Scanner;

public class TiacTacToe {

    static int turns;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] gameBoard = { { '_', '|', '_', '|', '_' }, { '_', '|', '_', '|', '_' }, { ' ', '|', ' ', '|', ' ' } };

        printBoard(gameBoard);

        boolean gameOver = false;
        boolean playAgain = true;
        while (playAgain) {
            while (!gameOver) {
                playerMove(gameBoard);

                gameOver = isGameOver(gameBoard);

                if (gameOver) {
                    break;
                }
            }

            System.out.println("Would you like to play again? Y/N? ");
            input.nextLine();
            String result = input.nextLine();

            switch (result) {

                case "Y":
                case "y":
                    playAgain = true;
                    System.out.println("Cool, let's play again");
                    resetBoard(gameBoard);
                    gameOver = false;
                    printBoard(gameBoard);
                    break;

                case "N":
                case "n":
                    playAgain = false;
                    System.out.println("Thanks for playing");

                default:
                    break;

            }

        }
    }

    public static void printBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void updateBoard(int position, int player, char[][] gameBoard) {

        char character;

        if (player == 1) {
            character = 'X';
        } else {
            character = 'O';
        }

        switch (position) {
            case 1:
                gameBoard[0][0] = character;
                printBoard(gameBoard);
                break;
            case 2:
                gameBoard[0][2] = character;
                printBoard(gameBoard);
                break;
            case 3:
                gameBoard[0][4] = character;
                printBoard(gameBoard);
                break;
            case 4:
                gameBoard[1][0] = character;
                printBoard(gameBoard);
                break;
            case 5:
                gameBoard[1][2] = character;
                printBoard(gameBoard);
                break;
            case 6:
                gameBoard[1][4] = character;
                printBoard(gameBoard);
                break;
            case 7:
                gameBoard[2][0] = character;
                printBoard(gameBoard);
                break;
            case 8:
                gameBoard[2][2] = character;
                printBoard(gameBoard);
                break;
            case 9:
                gameBoard[2][4] = character;
                printBoard(gameBoard);
                break;
            default:
                break;

        }

    }

    public static void playerMove(char[][] gameBoard) {

        System.out.println("Please choose 1 for X or 2 for O: ");
        int player = input.nextInt();

        System.out.println("Please make your move (1-9)");
        int move = input.nextInt();

        boolean result = validMove(move, gameBoard);

        while (!result) {
            System.out.println("Sorry, invalid move. please change your selection and try again");
            move = input.nextInt();
            result = validMove(move, gameBoard);
        }

        System.out.println("Player moved at position: " + move);
        turns++;

        updateBoard(move, player, gameBoard);

    }

    public static boolean validMove(int move, char[][] gameBoard) {

        switch (move) {
            case 1:
                if (gameBoard[0][0] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (gameBoard[0][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (gameBoard[0][4] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 4:
                if (gameBoard[1][0] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if (gameBoard[1][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 6:
                if (gameBoard[1][4] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 7:
                if (gameBoard[2][0] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 8:
                if (gameBoard[2][2] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 9:
                if (gameBoard[2][4] == ' ') {
                    return true;
                } else {
                    return false;
                }

            default:
                return false;
        }

    }

    public static boolean isGameOver(char[][] gameBoard) {
        // horizontal wins
        if (gameBoard[0][0] == 'X' && gameBoard[0][2] == 'X' && gameBoard[0][4] == 'X') {
            System.out.println("Player X Wins");
            return true;
        }
        if (gameBoard[0][0] == 'O' && gameBoard[0][2] == 'O' && gameBoard[0][4] == 'O') {
            System.out.println("Player O Wins");
            return true;
        }

        if (gameBoard[1][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[1][4] == 'X') {
            System.out.println("Player X Wins");
            return true;
        }
        if (gameBoard[1][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[1][4] == 'O') {
            System.out.println("Player O Wins");
            return true;
        }
        if (gameBoard[2][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Player X Wins");
            return true;
        }
        if (gameBoard[2][0] == 'O' && gameBoard[2][2] == 'O' && gameBoard[2][4] == 'O') {
            System.out.println("Player O Wins");
            return true;
        }
        // vertical wins
        if (gameBoard[0][0] == 'X' && gameBoard[1][0] == 'X' && gameBoard[2][0] == 'X') {
            System.out.println("Player X Wins");
            return true;
        }
        if (gameBoard[0][0] == 'O' && gameBoard[1][0] == 'O' && gameBoard[2][0] == 'O') {
            System.out.println("Player O Wins");
            return true;
        }

        if (gameBoard[0][2] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][2] == 'X') {
            System.out.println("Player X Wins");
            return true;
        }
        if (gameBoard[0][2] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][2] == 'O') {
            System.out.println("Player O Wins");
            return true;
        }
        if (gameBoard[0][4] == 'X' && gameBoard[1][4] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Player X Wins");
            return true;
        }

        if (gameBoard[0][4] == 'O' && gameBoard[1][4] == 'O' && gameBoard[2][4] == 'O') {
            System.out.println("Player O Wins");
            return true;
        }
        // diagonal wins
        if (gameBoard[0][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Player X Wins");
            return true;
        }

        if (gameBoard[0][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][4] == 'O') {
            System.out.println("Player O Wins");
            return true;
        }

        if (gameBoard[2][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[0][4] == 'X') {
            System.out.println("Player X Wins");
            return true;
        }

        if (gameBoard[2][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[0][4] == 'O') {
            System.out.println("Player O Wins");
            return true;
        }
        if (isFull()) {
            System.out.println("It's a tie!");
            return true;
        } else {
            return false;
        }

    }

    public static boolean isFull() {
        // returns true if nine turns have been played and false otherwise
        if (turns >= 9) {
            return true;
        } else {
            return false;
        }
    }

    public static void resetBoard(char[][] gameBoard) {
        gameBoard[0][0] = '_';
        gameBoard[0][2] = '_';
        gameBoard[0][4] = '_';
        gameBoard[1][0] = '_';
        gameBoard[1][2] = '_';
        gameBoard[1][4] = '_';
        gameBoard[2][0] = ' ';
        gameBoard[2][2] = ' ';
        gameBoard[2][4] = ' ';
    }
}
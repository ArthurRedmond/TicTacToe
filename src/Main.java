import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        char[][] gameplay = startGame();

        printGame(gameplay);
        playGame(gameplay);


    }

    public static char[][] startGame() {
        Scanner scanner = new Scanner(System.in);
        char[][] inputArray = {{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}};
        return inputArray;
    }

    public static void playGame(char[][] gameplay) {
        while (result(gameplay).length() < 2) {
            playerX(gameplay);
            printGame(gameplay);
            if (result(gameplay).length() > 2) {
                break;
            }
            playerO(gameplay);
            printGame(gameplay);
            if (result(gameplay).length() > 2) {
                break;
            }
        }
        System.out.println(result(gameplay));
    }

    public static void playerX(char[][] gameplay) {
        Scanner scanner = new Scanner(System.in);
        int row = -1;
        int column = -1;

        while (true) {
            System.out.print("Enter the coordinates: ");
            String rowString = scanner.next();
            String columnString = scanner.next();
            scanner.nextLine();

            // Validate entries are base 10 digits
            row = Character.digit(rowString.charAt(0), 10);
            column = Character.digit(columnString.charAt(0), 10);

            if (row == -1 || column == -1) {
                System.out.println("You should enter numbers!");
                continue;
            } else if (row < 1 || row > 3 || column < 1 || column > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            } else if (gameplay[row - 1][column - 1] != ' ' && gameplay[row - 1][column - 1] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            break;
        }
        gameplay[row - 1][column - 1] = 'X';
    }

    public static void playerO(char[][] gameplay) {
        Scanner scanner = new Scanner(System.in);
        int row = -1;
        int column = -1;

        while (true) {
            System.out.print("Enter the coordinates: ");
            String rowString = scanner.next();
            String columnString = scanner.next();
            scanner.nextLine();

            // Validate entries are base 10 digits
            row = Character.digit(rowString.charAt(0), 10);
            column = Character.digit(columnString.charAt(0), 10);

            if (row == -1 || column == -1) {
                System.out.println("You should enter numbers!");
                continue;
            } else if (row < 1 || row > 3 || column < 1 || column > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            } else if (gameplay[row - 1][column - 1] != ' ' && gameplay[row - 1][column - 1] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            break;
        }
        gameplay[row - 1][column - 1] = 'O';
    }

    public static void printGame(char[][] gameplay) {
        String border = "---------";
        System.out.println(border);
        int index = 0;
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(gameplay[index][j] + " ");
            }
            System.out.println("|");
            index++;
        }
        System.out.println(border);
    }

    public static String result(char[][] gameplay) {
        int xCount = xCount(gameplay);
        int oCount = oCount(gameplay);
        String returnString = "";

        char[] winHorizontalX = {'X', 'X', 'X'};
        char[] winHorizontalY = {'O', 'O', 'O'};

        // Checks if the number of turns is out of count. Should be no more than 5:4
        if (Math.abs(xCount - oCount) > 1) {
            returnString = "Impossible";
            // Checks to see if the game is possible if there are two "winners" horizontal
        } else if ((Arrays.equals(gameplay[0], winHorizontalX) ||
                Arrays.equals(gameplay[1], winHorizontalX) ||
                Arrays.equals(gameplay[2], winHorizontalX)) &&
                (Arrays.equals(gameplay[0], winHorizontalY) ||
                        Arrays.equals(gameplay[1], winHorizontalY) ||
                        Arrays.equals(gameplay[2], winHorizontalY))) {
            returnString = "Impossible";
            // Checks to see if the game is possible if there are two "winners" vertical
        } else if (((gameplay[0][0] == 'X' && gameplay[1][0] == 'X' && gameplay[2][0] == 'X') ||
                (gameplay[0][1] == 'X' && gameplay[1][1] == 'X' && gameplay[2][1] == 'X') ||
                (gameplay[0][2] == 'X' && gameplay[1][2] == 'X' && gameplay[2][2] == 'X')) &&
                ((gameplay[0][0] == 'O' && gameplay[1][0] == 'O' && gameplay[2][0] == 'O') ||
                        (gameplay[0][1] == 'O' && gameplay[1][1] == 'O' && gameplay[2][1] == 'O') ||
                        (gameplay[0][2] == 'O' && gameplay[1][2] == 'O' && gameplay[2][2] == 'O'))) {
            returnString = "Impossible";
            // If X is in all three spaces horizontal
        } else if (Arrays.equals(gameplay[0], winHorizontalX) ||
                Arrays.equals(gameplay[1], winHorizontalX) ||
                Arrays.equals(gameplay[2], winHorizontalX)) {
            returnString = "X wins";
            // If O is in all three spaces horizontal
        } else if (Arrays.equals(gameplay[0], winHorizontalY) ||
                Arrays.equals(gameplay[1], winHorizontalY) ||
                Arrays.equals(gameplay[2], winHorizontalY)) {
            returnString = "O wins";
            // if X is in all three spaces vertical
        } else if ((gameplay[0][0] == 'X' && gameplay[1][0] == 'X' && gameplay[2][0] == 'X') ||
                (gameplay[0][1] == 'X' && gameplay[1][1] == 'X' && gameplay[2][1] == 'X') ||
                (gameplay[0][2] == 'X' && gameplay[1][2] == 'X' && gameplay[2][2] == 'X')) {
            returnString = "X wins";
            // if O is in all three spaces vertical
        } else if ((gameplay[0][0] == 'O' && gameplay[1][0] == 'O' && gameplay[2][0] == 'O') ||
                (gameplay[0][1] == 'O' && gameplay[1][1] == 'O' && gameplay[2][1] == 'O') ||
                (gameplay[0][2] == 'O' && gameplay[1][2] == 'O' && gameplay[2][2] == 'O')) {
            returnString = "O wins";
            // If X is in diagonal positions
        } else if ((gameplay[0][0] == 'X' && gameplay[1][1] == 'X' && gameplay[2][2] == 'X') ||
                (gameplay[0][2] == 'X' && gameplay[1][1] == 'X' && gameplay[2][0] == 'X')) {
            returnString = "X wins";
            // If O is in diagonal positions
        } else if ((gameplay[0][0] == 'O' && gameplay[1][1] == 'O' && gameplay[2][2] == 'O') ||
                (gameplay[0][2] == 'O' && gameplay[1][1] == 'O' && gameplay[2][0] == 'O')) {
            returnString = "O wins";
        } else if (!containsSpaces(gameplay)){
            // Return "Draw" if no winner determined
            returnString = "Draw";
        }
        return returnString;
    }

    public static int xCount(char[][] gameplay) {
        int count = 0;
        for (char[] characterArray : gameplay
        ) {
            for (char character : characterArray
            ) {
                if (character == 'X') {
                    count++;
                }
            }
        }
        return count;
    }

    public static int oCount(char[][] gameplay) {
        int count = 0;
        for (char[] characterArray : gameplay
        ) {
            for (char character : characterArray
            ) {
                if (character == 'O') {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean containsSpaces(char[][] gameplay) {
        boolean output = false;
        for (char[] characterArray : gameplay
        ) {
            for (char character : characterArray
            ) {
                if (character == ' ' || character == '_') {
                    output = true;
                }
            }
        }
        return output;
    }
}

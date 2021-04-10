import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        char[][] gameplay = startGame();

        printGame(gameplay);
        playerX(gameplay);
        printGame(gameplay);
        //        System.out.println(result(inputArray));

    }

    public static char[][] startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String input = scanner.nextLine().toUpperCase();
        char[][] inputArray = new char[3][3];
        inputArray[0] = input.substring(0, 3).toCharArray();
        inputArray[1] = input.substring(3, 6).toCharArray();
        inputArray[2] = input.substring(6, 9).toCharArray();
        return inputArray;
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
            row = Character.digit(rowString.charAt(0),10);
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
        String output = "Draw";

        int xCount = xCount(gameplay);
        int oCount = oCount(gameplay);

        char[] winHorizontalX = {'X', 'X', 'X'};
        char[] winHorizontalY = {'O', 'O', 'O'};

        // Checks if the number of turns is out of count. Should be no more than 5:4
        if (Math.abs(xCount - oCount) > 1) {
            return "Impossible";
            // Checks to see if the game is possible if there are two "winners" horizontal
        } else if ((Arrays.equals(gameplay[0], winHorizontalX) ||
                Arrays.equals(gameplay[1], winHorizontalX) ||
                Arrays.equals(gameplay[2], winHorizontalX)) &&
                (Arrays.equals(gameplay[0], winHorizontalY) ||
                        Arrays.equals(gameplay[1], winHorizontalY) ||
                        Arrays.equals(gameplay[2], winHorizontalY))) {
            return "Impossible";
            // Checks to see if the game is possible if there are two "winners" vertical
        } else if (((gameplay[0][0] == 'X' && gameplay[1][0] == 'X' && gameplay[2][0] == 'X') ||
                (gameplay[0][1] == 'X' && gameplay[1][1] == 'X' && gameplay[2][1] == 'X') ||
                (gameplay[0][2] == 'X' && gameplay[1][2] == 'X' && gameplay[2][2] == 'X')) &&
                ((gameplay[0][0] == 'O' && gameplay[1][0] == 'O' && gameplay[2][0] == 'O') ||
                (gameplay[0][1] == 'O' && gameplay[1][1] == 'O' && gameplay[2][1] == 'O') ||
                (gameplay[0][2] == 'O' && gameplay[1][2] == 'O' && gameplay[2][2] == 'O'))) {
            return "Impossible";
            // If X is in all three spaces horizontal
        } else if (Arrays.equals(gameplay[0], winHorizontalX) ||
                Arrays.equals(gameplay[1], winHorizontalX) ||
                Arrays.equals(gameplay[2], winHorizontalX)) {
            return "X wins";
            // If O is in all three spaces horizontal
        } else if (Arrays.equals(gameplay[0], winHorizontalY) ||
                Arrays.equals(gameplay[1], winHorizontalY) ||
                Arrays.equals(gameplay[2], winHorizontalY)) {
            return "O wins";
            // if X is in all three spaces vertical
        } else if ((gameplay[0][0] == 'X' && gameplay[1][0] == 'X' && gameplay[2][0] == 'X') ||
                (gameplay[0][1] == 'X' && gameplay[1][1] == 'X' && gameplay[2][1] == 'X') ||
                (gameplay[0][2] == 'X' && gameplay[1][2] == 'X' && gameplay[2][2] == 'X')) {
            return "X wins";
            // if O is in all three spaces vertical
        } else if ((gameplay[0][0] == 'O' && gameplay[1][0] == 'O' && gameplay[2][0] == 'O') ||
                (gameplay[0][1] == 'O' && gameplay[1][1] == 'O' && gameplay[2][1] == 'O') ||
                (gameplay[0][2] == 'O' && gameplay[1][2] == 'O' && gameplay[2][2] == 'O')) {
            return "O wins";
            // If X is in diagonal positions
        } else if ((gameplay[0][0] == 'X' && gameplay[1][1] == 'X' && gameplay[2][2] == 'X') ||
                (gameplay[0][2] == 'X' && gameplay[1][1] == 'X' && gameplay[2][0] == 'X')) {
            return  "X wins";
            // If O is in diagonal positions
        } else if ((gameplay[0][0] == 'O' && gameplay[1][1] == 'O' && gameplay[2][2] == 'O') ||
                (gameplay[0][2] == 'O' && gameplay[1][1] == 'O' && gameplay[2][0] == 'O')) {
            return  "X wins";
            // If above has not caught, are there still moves?
        } else if (containsSpaces(gameplay)) {
            return "Game not finished";
        }
        // Return "Draw" if no winner determined
        return output;
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

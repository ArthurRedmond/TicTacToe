import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.nextLine().toUpperCase();

        char[][] inputArray = new char[3][3];

        inputArray[0] = input.substring(0, 3).toCharArray();
        inputArray[1] = input.substring(3, 6).toCharArray();
        inputArray[2] = input.substring(6, 9).toCharArray();


        printGame(inputArray);
        System.out.println(result(inputArray));
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
        } else if ((gameplay[0][0] == 'X' && gameplay[1][0] == 'X' && gameplay[2][0] == 'X') ||
                (gameplay[0][1] == 'X' && gameplay[1][1] == 'X' && gameplay[2][1] == 'X') ||
                (gameplay[0][2] == 'X' && gameplay[1][2] == 'X' && gameplay[2][2] == 'X') &&
                (gameplay[0][0] == 'O' && gameplay[1][0] == 'O' && gameplay[2][0] == 'O') ||
                (gameplay[0][1] == 'O' && gameplay[1][1] == 'O' && gameplay[2][1] == 'O') ||
                (gameplay[0][2] == 'O' && gameplay[1][2] == 'O' && gameplay[2][2] == 'O')) {
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

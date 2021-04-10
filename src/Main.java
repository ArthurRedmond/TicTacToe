import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter cells: ");
        String input = scanner.nextLine();
        char[] inputArray = input.toCharArray();

        String border = "---------";
        System.out.println(border);
        int index = 0;
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(inputArray[index] + " ");
                index++;
            }
            System.out.println("|");
        }
        System.out.println(border);
    }
}

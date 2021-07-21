package fundamentals.reverse;

import java.util.Scanner;

/**
 * Отобразить в окне консоли аргументы командной строки в обратном порядке.
 */
public class ArgumentReverter {
    private String[] argument = getPartOfArgument();

    private String[] getPartOfArgument() {
        String invitationLine = "type line of arguments >>";
        System.out.print(invitationLine);
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextLine()) {
            System.out.print(invitationLine);
            scanner.nextLine();
        }
        String argument = scanner.nextLine();
        argument = argument.trim();
        if (argument.isEmpty()) {
            System.out.println("no arguments in line! try again!");
            getPartOfArgument();
        }
        return argument.split(" ");
    }

    public void printReverseArgument() {
        for (int i = argument.length - 1; i >= 0; i--) {
            System.out.print(argument[i] + " ");
        }
    }
}

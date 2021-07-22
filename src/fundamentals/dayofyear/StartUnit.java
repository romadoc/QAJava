package fundamentals.dayofyear;

import java.util.Scanner;

public class StartUnit {
    public static void main(String[] args) {
        Main main = new Main();
        main.mounthName(enterDigit());
    }

    static int enterDigit() {
        int x = 0;
        String invitation = "type number of month (in range 1 - 12) >> ";
        System.out.print(invitation);
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.print(invitation);
            scanner.next();
        }
        x = scanner.nextInt();
        return x;
    }
}

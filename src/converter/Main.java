package converter;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter number in decimal system: ");
        int number = scanner.nextInt();

        System.out.println("Enter target base: ");
        int base = scanner.nextInt();

        var result = Integer.toString(number, base);
        System.out.println("Conversion result: " + result);

    }
}

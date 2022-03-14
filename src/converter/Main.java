package converter;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Do you want to convert /from decimal or /to decimal? (To quit type /exit) ");
            switch (scanner.nextLine()) {
                case "/to":
                    toDecimal();
                    break;
                case "/from":
                    fromDecimal();
                    break;
                case "/exit":
                    return;
                default:
            }
        }
    }

    private static void fromDecimal() {
        System.out.println("Enter a number in decimal system: ");
        int number = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter target base: ");
        int base = Integer.parseInt(scanner.nextLine());

        var result = Integer.toString(number, base);
        System.out.println("Conversion result: " + result);
    }

    private static void toDecimal() {
        System.out.println("Enter source number: ");
        var number = scanner.nextLine();

        System.out.println("Enter source base: ");
        int base = Integer.parseInt(scanner.nextLine());

        var result = Integer.toString(Integer.parseInt(number, base), 10);
        System.out.println("Conversion to decimal result: " + result);
    }
}

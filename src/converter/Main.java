package converter;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
            var input = scanner.nextLine();

            if ("/exit".equals(input)) {
                break;
            }

            String[] data = input.split("\\s");


            while (true) {

                System.out.printf("Enter number in base %s to convert to base %s "
                        + "(To go back type /back) %n", data[0], data[1]);

                var number = scanner.nextLine();

                if ("/back".equals(number)) {
                    break;
                }

                var result = new BigInteger(number, Integer.parseInt(data[0])).toString(Integer.parseInt(data[1]));
                System.out.println("Conversion result: " + result);

            }
        }
    }
}

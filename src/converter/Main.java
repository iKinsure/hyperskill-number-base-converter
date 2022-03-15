package converter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int PRECISION = 5;

    public static void main(String[] args) {

        String[] data;
        int fromBase, toBase;
        String input, result;

        while (true) {

            System.out.println("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
            input = scanner.nextLine();

            if ("/exit".equals(input)) {
                break;
            }

            data = input.split("\\s");
            fromBase = Integer.parseInt(data[0]);
            toBase = Integer.parseInt(data[1]);

            while (true) {

                System.out.printf("Enter number in base %d to convert to base %d "
                        + "(To go back type /back) %n", fromBase, toBase);
                input = scanner.nextLine();

                if ("/back".equals(input)) {
                    break;
                }

                result = input.contains(".")
                        ? decimalToBase(decimalFromBase(input, fromBase), toBase)
                        : new BigInteger(input, fromBase).toString(toBase);
                System.out.println("Conversion result: " + result);
            }
        }
    }

    private static String decimalToBase(String number, int toBase) {
        String newNumber = new BigDecimal(number)
                .multiply(BigDecimal.valueOf(Math.pow(toBase, PRECISION)))
                .toBigInteger()
                .toString(toBase);
        return new StringBuilder(newNumber)
                .insert(newNumber.length() - PRECISION, newNumber.startsWith(".") ? "0." : ".")
                .toString();
    }

    private static String decimalFromBase(String number, int fromBase) {
        AtomicInteger power = new AtomicInteger(number.indexOf('.') - 1);
        return number.chars()
                .filter(c -> c != '.')
                .map(Character::getNumericValue)
                .mapToObj(i -> new BigDecimal(i)
                        .multiply(BigDecimal.valueOf(Math.pow(fromBase, power.getAndDecrement()))))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ONE)
                .toString();
    }

}

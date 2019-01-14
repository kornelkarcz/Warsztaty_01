package guessinggame;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {

        System.out.println("Zgadnij liczbę.");

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int randNumber = random.nextInt(100) + 1;
        int number = getNumber(scanner);

        while (true) {
            if (randNumber > number) {
                System.out.println("Za mało!");
                number = getNumber(scanner);
            } else if (randNumber < number) {
                System.out.println("Za dużo!");
                number = getNumber(scanner);
            } else if (randNumber == number) {
                System.out.println("Zgadłeś!");
                break;
            }
        }
        scanner.close();

    }

    private static int getNumber(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            String value = scanner.next();
            System.out.println("'" + value + "' nie jest liczbą.");
        }
        int number = scanner.nextInt();
        return number;
    }

}

package reversedguessinggame;

import java.util.Scanner;

public class ReversedGuessingGame {

    public static void main(String[] args) {

        System.out.println("Pomyśl liczbę od 0 do 1000, a ja ją zgadnę w max. 10 próbach.");
        Scanner scanner = new Scanner(System.in);
        int min = 0;
        int max = 1000;
        int counter = 0;
        boolean result = false;

        while (!result) {
            int guess = ((max - min) / 2) + min;
            System.out.println("Zgaduję: " + guess);
            counter++;
            String answer = getRightString(scanner);


            switch (answer) {
                case "za malo":
                    min = guess;
                    result = false;
                    counter++;
                    break;
                case "za duzo":
                    max = guess;
                    result = false;
                    counter++;
                    break;
                case "zgadles":
                    System.out.println("Wygrałem");
                    result = true;
                    break;
                default:
                    System.out.println("O rany jesteś pregrany");
            }
        }
        scanner.close();

    }

    private static String getRightString(Scanner scanner) {
        String str = scanner.nextLine().toLowerCase();
        while (!str.equals("za malo") && !str.equals("za duzo") && !str.equals("zgadles")) {

            System.out.println("Podaj poprawną odpowiedź.");
            str = scanner.nextLine();
        }
        return str;


    }

}


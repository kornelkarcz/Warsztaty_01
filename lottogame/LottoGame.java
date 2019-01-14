package lottogame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LottoGame {

    public static void main(String[] args) {


        System.out.println("Wybierz 6 liczb z przedziału od 1 do 49.");
        int[] tab = pickNumbers();
        int[] tab1 = generateNumbers();
        int score = score(tab, tab1);
        checkScore(score);


    }

    private static int score(int[] pickNumberTab, int[] generateNumberTab) {
        int scoreCounter = 0;
        for (int i = 0; i < pickNumberTab.length; i++) {
            for (int j = 0; j < generateNumberTab.length; j++) {
                if (pickNumberTab[i] == generateNumberTab[j]) {
                    scoreCounter++;
                }

            }

        }
        return scoreCounter;

    }

    private static void checkScore(int score) {
        switch (score) {
            case 1:
                System.out.println("Gratulacje! Trafiłeś " + score + "!");
                break;
            case 2:
                System.out.println("Gratulacje! Trafiłeś " + score + "!");
                break;
            case 3:
                System.out.println("Gratulacje! Trafiłeś " + score + "!");
                break;
            case 4:
                System.out.println("Gratulacje! Trafiłeś " + score + "!");
                break;
            case 5:
                System.out.println("Gratulacje! Trafiłeś " + score + "!");
                break;
            case 6:
                System.out.println("Gratulacje! Trafiłeś " + score + "!");
                break;
            default:
                System.out.println("Niesety nic nie trafileś. Próbuj dalej!");
        }
    }


    private static boolean containsElem(int[] tab, int elem) {
        int[] var2 = tab;
        int size = tab.length;

        for (int i = 0; i < size; i++) {
            int el = var2[i];
            if (el == elem) {
                return true;
            }
        }

        return false;
    }

    private static int[] pickNumbers() {
        Scanner scanner = new Scanner(System.in);

        int[] tab = new int[6];

        for (int i = 0; i < tab.length; i++) {
            int number = getNumber(scanner);
            if (number > 49 || number < 1) {
                System.out.println("Podana liczba jest spoza przedziału 1 - 49. Podaj poprawną liczbę.");
                i--;
            } else if (containsElem(tab, number)) {
                System.out.println("Podana liczba została już wprowadzona. Podaj liczbę jeszcze raz.");
                i--;
            }
            tab[i] = number;
        }
        scanner.close();
        Arrays.sort(tab);
        return tab;
    }

    private static int[] generateNumbers() {
        Random random = new Random();
        int[] tab = new int[6];

        for (int i = 0; i < tab.length; i++) {
            int randNumber = random.nextInt(49) + 1;
            if (containsElem(tab, randNumber)) {
                System.out.println("Komputer wylosował drugi raz tę samą liczbę.");
                i--;
            } else {
                tab[i] = randNumber;
            }

        }
        Arrays.sort(tab);
        return tab;

    }

    private static int getNumber(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            String value = scanner.next();
            System.out.println("Wartość '" + value + "' nie jest wartością liczbową. Podaj liczbę z przedziału 1 - 49.");
        }
        int number = scanner.nextInt();
        return number;


    }


}

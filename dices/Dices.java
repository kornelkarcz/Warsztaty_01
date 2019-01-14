package dices;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Dices {

    public static void main(String[] args) {

        System.out.println("Podaj ilość rzutów oraz rodzaj kostki według podanej konwencji: \n"
                + "xDy+z, gdzie: \n"
                + "x - liczba rzutów,\n" +
                "y - rodzaj kostki,\n" +
                "z - liczba, którą należy dodać lub odjąć.");

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int size = decipherThrows(str);
        System.out.println(size);

        int[] tab = decipherDice(size, str);
        String elements = Arrays.toString(tab);
        System.out.println(elements);

        int modifier = decipherModifier(str);
        System.out.println(modifier);

        int score = getsScore(tab, modifier);
        System.out.println("Gratulacje Twój wynik to: " + score);

    }

    private static int decipherThrows(String str) {
        int getIndexOfD = str.indexOf('D');
        int diceThrows = 0;
        if (getIndexOfD == 0) {
            diceThrows = 1;
        } else {

            String substr = str.substring(0, getIndexOfD);
            diceThrows = Integer.parseInt(substr);
        }
        return diceThrows;
    }

    private static int[] decipherDice(int size, String str) {
        int[] tab = new int[size];
        Random random = new Random();

        int getIndexOfModifier = 0;

        if (str.contains("+")) {
            getIndexOfModifier = str.indexOf("+");
        } else if (str.contains("-")) {
            getIndexOfModifier = str.indexOf("-");
        }
        int getIndexOfD = str.indexOf("D");
        String substr = str.substring(getIndexOfD + 1, getIndexOfModifier);
        int diceType = Integer.parseInt(substr);

        for (int i = 0; i < tab.length; i++) {
            tab[i] = random.nextInt(size) + 1;

        }

        return tab;

    }


    private static int decipherModifier(String str) {
        int getIndexOfModifier = 0;
        int modifier = 0;

        if (str.contains("+")) {
            getIndexOfModifier = str.indexOf("+");
            String substr = str.substring(getIndexOfModifier + 1, str.length());
            modifier = Integer.parseInt(substr);
        } else if (str.contains("-")) {
            getIndexOfModifier = str.indexOf("-");
            String substr = str.substring(getIndexOfModifier + 1, str.length());
            modifier = Integer.parseInt(substr) * -1;
        }

        return modifier;
    }

    private static int getsScore(int[] tab, int modifier) {
        int sum = modifier;

        for (int i = 0; i < tab.length; i++) {
            sum += tab[i];
        }
        return sum;
    }
}

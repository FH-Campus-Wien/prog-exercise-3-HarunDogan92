package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class App {

    // Implement all methods as public static

    public static void main(String[] args) {
        oneMonthCalendar(31, 2);
    }

    public static void oneMonthCalendar(int monthLength, int firstDay) {
        int day = 1;
        while (day < firstDay) {
            System.out.printf("%3s", " ");
            day++;
        }
        for (int i = 1; i <= monthLength; i++) {
            System.out.printf("%2d", i);
            System.out.print(" ");
            day++;
            if (day > 7 || i == monthLength) {
                System.out.println();
                day = 1;
            }
        }
    }

    public static long[] lcg(long seed) {
        long[] output = new long[10];
        int a = 1103515245;
        int c = 12345;
        long m = (long) Math.pow(2, 31);
        long x = seed;
        for (int i = 0; i < 10; i++) {
            x = ((a * x) + c) % m;
            output[i] = x;
        }
        return output;
    }

    public static void guessingGame(int numberToGuess) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        int tries = 1;
        while (input != numberToGuess && tries <= 10) {
            System.out.print("Guess number " + tries + ": ");
            input = scanner.nextInt();
            if (tries == 10){
                System.out.println("You lost! Have you ever heard of divide & conquer?");
            } else if (input > numberToGuess) {
                System.out.println("The number AI picked is lower than your guess.");
            } else if (input < numberToGuess) {
                System.out.println("The number AI picked is higher than your guess.");
            } else {
                System.out.println("You won wisenheimer!");
            }
            tries++;
        }
    }

    public static int randomNumberBetweenOneAndHundred() {
        return new Random().nextInt( 100) + 1;
    }

    public static boolean swapArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            array1[i] = array1[i] + array2[i];
            array2[i] = array1[i] - array2[i];
            array1[i] = array1[i] - array2[i];
        }

        return true;
    }

    public static String camelCase(String input) {
        char[] inputArray = input.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < inputArray.length; i++) {
            if (checkIfLetter(inputArray[i])) {
                if (stringBuilder.length() == 0 && isLower(inputArray[i])) {
                    stringBuilder.append((char) (inputArray[i] - 32));
                } else if (inputArray[i - 1] == 32 && isLower(inputArray[i])) {
                    stringBuilder.append((char)(inputArray[i] - 32));
                } else if(inputArray[i - 1] != 32 && !isLower(inputArray[i])){
                    stringBuilder.append((char)(inputArray[i] + 32));
                } else {
                    stringBuilder.append(inputArray[i]);
                }
            }
        }
        return stringBuilder.toString();
    }

    private static boolean checkIfLetter(int letter) {
        return (letter < 123 && letter > 96) || (letter  < 91 && letter > 64);
    }

    private static boolean isLower(int letter) {
        return letter < 123 && letter > 96;
    }


    public static int checkDigit(int[] input) {
        int[] produkt = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            produkt[i] = input[i] * (i + 2);
        }
        int output = 11 - (IntStream.of(produkt).sum() % 11);
        if (output == 10) {
            output = 0;
        } else if (output == 11) {
            output = 5;
        }
        return output;
    }
}
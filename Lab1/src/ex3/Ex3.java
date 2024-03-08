package ex3;

import java.util.Arrays;
import java.util.Random;

public class Ex3 {
    public static void main(String[] args) {
        // Initialize array to store random numbers
        int[] randomNumbers = new int[10];

        // Generate and store random numbers
        Random rand = new Random();
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = rand.nextInt(100); // Generates random numbers between 0 and 99
        }

        // Sort the array
        Arrays.sort(randomNumbers);

        // Display sorted numbers
        System.out.println("Sorted random numbers:");
        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.print(randomNumbers[i]+" ");
        }
    }
}


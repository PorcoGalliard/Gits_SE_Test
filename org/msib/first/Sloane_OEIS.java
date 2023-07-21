package org.msib.first;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sloane_OEIS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Input: ");
            int n = scanner.nextInt();
            int[] result = calculateSloaneOEIS(n);
            System.out.print("Output: ");

            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
                if (i < result.length - 1) {
                    System.out.print("-");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Not a valid input, input a proper number instead");
        } catch (NegativeArraySizeException e) {
            System.out.println("Input cannot be a negative number");
        }
    }

    public static int[] calculateSloaneOEIS(int n) {
        int[] result = new int[n];
        int sequence_number = 0;
        result[0] = 1;

        for (int i = 1; i < n; i++) {
            sequence_number += i;
            result[i] = sequence_number + 1;
        }

        return result;
    }
}

package org.msib.third;

import java.util.Scanner;

public class Balanced_Bracket {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Masukkan bracket anda: ");
        String input = SCANNER.nextLine();
        String bracket = input.trim().replaceAll("\\s+", "");
        System.out.println(isBracketBalanced(bracket));
    }

    public static String isBracketBalanced(String brackets) {
        int i = -1;
        char[] stack = new char[brackets.length()];
        for (char b : brackets.toCharArray()) {
            if (b == '(' || b == '{' || b == '[')
                stack[++i] = b;
            else {
                if (i >= 0
                        && ((stack[i] =='(' && b == ')')
                        || (stack[i] == '{' && b == '}')
                        || (stack[i] == '[' && b == ']')))
                    i--;
                else {
                    return "NO";
                }
            }
        }
        return i == -1 ? "YES" : "NO";
    }
}

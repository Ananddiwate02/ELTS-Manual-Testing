package org.example;
import java.util.Scanner;
public class java1 {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(N + " x " + i + " = " + (N * i));
        }
    }
}

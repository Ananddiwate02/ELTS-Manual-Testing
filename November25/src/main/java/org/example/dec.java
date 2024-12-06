package org.example;

import java.util.Scanner;

public class dec {
    public static void main(String... args) {
        if (flag) System.out.println(B * H);
    }

    static int B, H;
    static boolean flag = true;

    static {
        Scanner sc = new Scanner(System.in);
        B = sc.nextInt();
        H = sc.nextInt();
        if (B <= 0 || H <= 0) {
            flag = false;
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }
}


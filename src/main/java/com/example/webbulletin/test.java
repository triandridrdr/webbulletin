package com.example.webbulletin;

import java.util.Scanner;

public class test {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        // Input
        long initialFund = scanner.nextLong();
        int profitPerYear = scanner.nextInt();
        int years = scanner.nextInt();

        // Validasi input
        if (initialFund < 1000 || initialFund > 1000000000 || 
            profitPerYear < 1 || profitPerYear > 20 || 
            years < 1 || years > 40) {
            System.out.println("Wrong Input");
            return;
        }

        // Perhitungan return dengan reinvestasi menggunakan looping
        double total = initialFund;
        for (int i = 0; i < years; i++) {
            total += total * profitPerYear / 100.0;
        }

        // Cetak hasil dibulatkan ke bawah
        System.out.println("Rp " + (long) Math.floor(total));
    }

}

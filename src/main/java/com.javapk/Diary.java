package com.javapk;

import com.javapk.Geolocation;

import java.util.Scanner;

public class Diary {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner input = new Scanner(System.in);

        int choice = input.nextInt();

        switch (choice) {
            case 1 -> //DiaryEntry.addEntry()
                    Geolocation.main();

            case 3 -> MapDisplay.main();

            default -> System.out.println("Wychodzenie z programu");
        }

    }
}

package com.company;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*//Wpis wpis1 = new Wpis();
        // stworzenie konstruktorem bezparametrowym - aktualna data
        Date nowDate = new Date();
        System.out.println("Aktualna data: " + nowDate);

        // pobranie timestampu z daty
        long timestamp = nowDate.getTime();
        System.out.println("Aktualna data (timestamp): " + timestamp);

        // tworzenie daty z timestampu
        Date otherDate = new Date(123123123123L);
        System.out.println("Data stworzona z timestampu: " + otherDate);


        Scanner input = new Scanner(System.in);

        System.out.println("Podaj date [dd,mm,yyyy]: ");
        String date = input.nextLine();// pobranie daty od użytkownika

        DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("dd,MM,yyyy");
        LocalDate podanaData = LocalDate.parse(date, dateFormater);
        System.out.println(podanaData);*/

        //System.out.println(podanaData.getDayOfWeek());
        //LocalDate todayNextYear = podanaData.plusYears(1);
        //System.out.println(todayNextYear.getDayOfWeek());

        Wpis w1 = new Wpis();

    }
}

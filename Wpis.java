package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Wpis {

    LocalDate data;
    String kraj, miejscowosc, opis;
    float temperatura, predkoscWiatru;
    int stopienZachmurzenia;

    Wpis() {
        System.out.println("Uzupełni informacje obserwacjami");
        setData();
        setMiejsce();
        setTemperatura();
        setPredkoscWiatru();
        setStopienZachmurzenia();
        setOpis();
    }

    void setData() {
/*
Dodać obslugę błędów przy wprowadzaniu daty od użytkownika
* */
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj date obserwacji dd,mm,yyyy:");
        String data = input.nextLine();
        DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("dd,MM,yyyy");
        LocalDate podanaData = LocalDate.parse(data, dateFormater);
        this.data = podanaData;
    }

    void setMiejsce() {
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj miejsce obserwacji.\nKraj: ");
        this.kraj = input.next();
        System.out.print("Miejscowość: ");
        this.miejscowosc = input.next();
    }

    void setOpis() {
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj opis pogody: ");
        this.opis = input.next();
    }

    void setTemperatura() {
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj temperature w stopniach Celcjusza: ");
        String temp;
        while (true) {
            try {
                temp = input.next();
                if (273.15f * -1 <= Float.parseFloat(temp)) {
                    this.temperatura = Float.parseFloat(temp);
                    break;
                } else
                    System.out.println("Nie ma takiej temperatury");

            } catch (Exception exception) {
                System.out.println("Wprowadz liczbe typu float");

            }
        }
    }

    void setPredkoscWiatru() {
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj prędkość wiatru: ");
        String wiatr;
        while (true) {
            try {
                wiatr = input.next();
                if (0.0f <= Float.parseFloat(wiatr)) {
                    this.predkoscWiatru = Float.parseFloat(wiatr);
                    break;
                } else
                    System.out.println("Predkosc nie moze być na wartosci ujemnej");
            } catch (Exception exception) {
                System.out.println("Wprowadz liczbe typu float");
            }
        }
    }

    void setStopienZachmurzenia() {
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj stopień zachmurzenia w skali 0-10: ");
        String chmura;
        while (true) {
            try {
                chmura = input.next();
                if (0 <= Integer.parseInt(chmura) && Integer.parseInt(chmura) <= 10) {
                    this.stopienZachmurzenia = Integer.parseInt(chmura);
                    break;
                } else
                    System.out.println("Podana wartość poza skalą");
            } catch (Exception exception) {
                System.out.println("Wprowadz liczbe typu int");
            }
        }

    }
    public void getWpis() {
        System.out.println("");

    }
}
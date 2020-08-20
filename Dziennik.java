package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Dziennik {
    ArrayList<Wpis> dziennik = new ArrayList<>();
    public void dodajWpis(Wpis wpis){
        dziennik.add(wpis);
    }
    public void wyswietlWpis(){
        if(!dziennik.isEmpty()) {
            int liczba;
            Scanner input = new Scanner(System.in);
            System.out.println("Podaj numer wpisu:");
            String wybor = input.next();
            System.out.println("-----------------------------------------");
            try {
                liczba = Integer.parseInt(wybor);
                if (liczba < dziennik.size()) {
                    System.out.println("\tWpis nr: " + liczba);
                    dziennik.get(liczba).getWpis();
                } else
                    System.out.println("Wpis o tym numerze nie istnieje");
            } catch (Exception exception) {
                System.out.println("Wprowadz liczbe typu int");
            }
        }
        else
            System.out.println("Dziennik jest pusty");
    }

    public void wyswietlWszystko(){
        if(!dziennik.isEmpty())
            for(Wpis iter : dziennik)
            {
                System.out.println("Wpis nr: " + dziennik.indexOf(iter));
                iter.getWpis();
            }
        else
            System.out.println("Dziennik jest pusty");
    }
    public void usunWpis(){
        if(!dziennik.isEmpty()) {
            int liczba;
            Scanner input = new Scanner(System.in);
            while (true) {
                System.out.println("Podaj numer wpisu:");
                String wybor = input.next();
                System.out.println("-----------------------------------------");
                try {
                    liczba = Integer.parseInt(wybor);
                    if (liczba < dziennik.size()) {
                        System.out.println("\nCzy na pewno chcesz usunąć ten wpis? [t/n]");
                        wybor = input.next();
                        if (wybor.equals("t")) {
                            dziennik.remove(liczba);
                            System.out.println("Wpis został pomyślnie usunięty");
                        } else
                            System.out.println("Wpis nie został usuniety");
                        break;
                    } else
                        System.out.println("Wpis o tym numerze nie istnieje");
                } catch (Exception exception) {
                    System.out.println("Wprowadz liczbe typu int");
                }
            }
        }
        else
            System.out.println("Dziennik jest pusty");
    }
    public void usunWszystko(){
        if(!dziennik.isEmpty()) {
            Scanner input = new Scanner(System.in);
            String wybor;
            System.out.println("Czy na pewno chcesz usunąć wszystkie wpisy w dzienniku? [t/n] ");
            wybor = input.next();
            if (wybor.equals("t")) {
                dziennik.clear();
                System.out.println("Wpis został pomyślnie usunięty");
            } else
                System.out.println("Wpis nie został usuniety");
        }
        else
            System.out.println("Dziennik jest pusty");
    }


}

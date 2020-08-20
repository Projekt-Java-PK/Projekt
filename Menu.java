package com.company;

import java.util.Scanner;

public class Menu {
    Dziennik dziennik = new Dziennik();
    Menu(){menu();}
    public void menu(){
        Scanner input = new Scanner(System.in);
        String wybor;
        int liczba = -1;
        while(true){
            System.out.println("-----------------------------------------");
            System.out.println("0 - dodaj wpis\n1 - wyswietl wybrany wpis\n2 - wyswietl wszystkie wpisy\n3 - usuń wybrany wpis\n4 - usuń wszystkie wpisy\n5 - koniec"); //można dodać również opcje edycji wybranego wpisu
            System.out.print("Wybierz numer: ");
            wybor = input.next();
            System.out.println("-----------------------------------------");
            try {
                liczba = Integer.parseInt(wybor);
                switch (liczba){
                    case 0:
                        Wpis wpis = new Wpis();
                        dziennik.dodajWpis(wpis);
                        //nastepuje zapis do pliku stworzonego obiektu
                        break;
                    case 1:
                         dziennik.wyswietlWpis();
                         break;
                    case 2:
                        dziennik.wyswietlWszystko();
                        break;
                    case 3:
                        dziennik.usunWpis();
                        break;
                    case 4:
                        dziennik.usunWszystko();
                        break;
                    case 5:
                        System.out.println("Koniec programu");
                        break;
                    default:
                        System.out.println("Liczba poza skalą wyboru");
                }
            }
            catch (Exception exception)
            {
                System.out.println("Wprowadz liczbe typu int");
            }
            if(liczba == 5)break;
        }
    }
}

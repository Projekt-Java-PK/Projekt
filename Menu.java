package com.company;

import java.util.Scanner;

public class Menu {
    public void menu(){
        Scanner input = new Scanner(System.in);
        String wybor;
        int liczba;
        while(true){
            System.out.print("0 - dodaj wpis\n1 - przeczytaj wpis\n2 - usun wpis\n3 - koniec"); //można dodać również opcje edycji wybranego wpisu
            System.out.println("Wybierz numer: ");
            wybor = input.next();
            try {
                liczba = Integer.parseInt(wybor);
                if (0 <= liczba && liczba <= 3)
                {
                    switch (liczba){
                        case 0:
                            Wpis wpis = new Wpis();
                            //Dodajemy utworzony obiekt do klasy Dziennik która przechowuje wszystkie wpisy
                            //nastepuje zapis do pliku stworzonego obiektu
                            break;
                        case 1:
                            System.out.print("0 - wyswietl wybrany wpis\n1 - wyswietl wszystkie wpisy\n2 - powrót");
                            System.out.println("Wybierz numer: ");
                            wybor = input.next();
                            try {
                                liczba = Integer.parseInt(wybor);
                                if (0 <= liczba && liczba <= 2){
                                    switch (liczba){
                                        case 0:
                                        case 1:
                                        case 2:
                                    }

                                }
                                else{
                                    System.out.println("Liczba poza skalą wyboru");
                                }
                            }
                            catch (Exception exception)
                            {
                                System.out.println("Wprowadz liczbe typu int");
                            }
                        case 2:
                            System.out.print("0 - usuń wybrany wpis\n1 - usuń wszystkie wpisy\n2 - powrót");
                            System.out.println("Wybierz numer: ");
                            wybor = input.next();
                            try {
                                liczba = Integer.parseInt(wybor);
                                if (0 <= liczba && liczba <= 2){
                                    switch (liczba){
                                        case 0:
                                        case 1:
                                        case 2:
                                    }
                                }
                                else{
                                    System.out.println("Liczba poza skalą wyboru");
                                }
                            }
                            catch (Exception exception)
                            {
                                System.out.println("Wprowadz liczbe typu int");
                            }
                        case 3:
                            System.out.printf("Koniec programu");
                            break;
                    }
                }
                else
                    System.out.println("Liczba poza skalą wyboru");
            }
            catch (Exception exception)
            {
                System.out.println("Wprowadz liczbe typu int");
            }
        }
    }
}

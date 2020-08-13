import java.util.Scanner;

public class Diary {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner input = new Scanner(System.in);
        String menu = """
        Wybierz jedną z akcji:
         1. Dodaj nowy wpis do dziennika i podaj współrzędne zjawiska
         2. Wyświetl wszystkie wpisy
         3. Wyświetl mapę i współrzędne obserwacji
         4. Wyświetl zgromadzone zdjęcia
         5. Wczytaj zapisany dziennik z pliku
         6. Zapisz dziennik do pliku
         7. Wyjście""";

        System.out.println(menu);

        int choice = input.nextInt();

        switch (choice) {
            case 1 -> //DiaryEntry.addEntry()
                    Geolocation.main();

            case 3 -> MapDisplay.main();

            default -> System.out.println("Wychodzenie z programu");
        }

    }
}

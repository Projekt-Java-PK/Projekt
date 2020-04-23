import java.util.Scanner;

public class Diary {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner input = new Scanner(System.in);
        String menu = """
        Wybierz jedną z akcji:
         1. Dodaj nowy wpis do dziennika
         2. Wyświetl wszystkie wpisy
         3. Wyświetl mapę z obserwacjami
         4. Wyświetl zgromadzone zdjęcia
         5. Wczytaj zapisany dziennik z pliku
         6. Zapisz dziennik do pliku
         7. Wyjście""";

        System.out.println(menu);
        int choice = input.nextInt();

        switch (choice) {
            // case 1 -> DiaryEntry.addEntry();
            // case 2 ->
            case 3 -> Geolocation.showMap();
            default -> System.out.println("Wychodzenie z programu");
        }

    }
}


package javaapplication16;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.*;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.List;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.io.Writer;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaApplication16 {
    
    public static void pogodynka(String nazwaMiasta,String dataP) throws IOException
{
    String adres = "adres";
    switch(nazwaMiasta)
            {
        case "Krakow":
            adres = "https://pogoda.onet.pl/prognoza-pogody/krakow-306020";
            break;
        case "Warszawa":
            adres = "https://pogoda.onet.pl/prognoza-pogody/warszawa-357732";
            break;
        case "Bialystok":
            adres = "https://pogoda.onet.pl/prognoza-pogody/bialystok-270085";
            break;
        case "Bydgoszcz":
            adres = "https://pogoda.onet.pl/prognoza-pogody/bydgoszcz-276560";
            break;
        case "Gdansk":
            adres = "https://pogoda.onet.pl/prognoza-pogody/gdansk-287788";
            break;
        case "Kielce":
            adres = "https://pogoda.onet.pl/prognoza-pogody/kielce-300882";
            break;
        case "Katowice":
            adres = "https://pogoda.onet.pl/prognoza-pogody/katowice-299998";
            break;
        case "Lublin":
            adres = "https://pogoda.onet.pl/prognoza-pogody/lublin-311624";
            break;
        case "Łodz":
            adres = "https://pogoda.onet.pl/prognoza-pogody/lodz-313660";
            break;
        case "Olsztyn":
            adres = "https://pogoda.onet.pl/prognoza-pogody/olsztyn-325715";
            break;
        case "Opole":
            adres = "https://pogoda.onet.pl/prognoza-pogody/opole-325985";
            break;
        case "Poznan":
            adres = "https://pogoda.onet.pl/prognoza-pogody/poznan-335979";
            break;
        case "Rzeszow":
            adres = "https://pogoda.onet.pl/prognoza-pogody/rzeszow-342624";
            break;
        case "Szczecin":
            adres = "https://pogoda.onet.pl/prognoza-pogody/szczecin-351892";
            break;
        case "Wroclaw":
            adres = "https://pogoda.onet.pl/prognoza-pogody/wroclaw-362450";
            break;
        case "Zielona Gora":
            adres = "https://pogoda.onet.pl/prognoza-pogody/zielona-gora-368720";
            break;
            }
    
    Clock clock = Clock.systemDefaultZone();
        ZoneId id = clock.getZone();
        Duration d = Duration.ofHours(1L);
        Clock clock1 = Clock.tick(clock, d);
        LocalDateTime ldt1 = LocalDateTime.now(clock1);
        //System.out.println("\r\nData: " + ldt1);
    
    String nazwaM =nazwaMiasta+".txt";
    File plik =new File("DZIENNIK/"+nazwaMiasta+"/"+dataP+".txt");
    Writer zapis = new BufferedWriter(new FileWriter("DZIENNIK/"+nazwaMiasta+"/"+dataP+".txt", true));  
        Connection connect = Jsoup.connect(adres);
        Document document = connect.get();
        System.out.println(nazwaMiasta);
        zapis.append("\r\n \r\nData: \r\n"+ldt1+"\r\n");
        zapis.append(nazwaMiasta+"\r\n");
            //temperatura
        Elements allH1 = document.select("#weatherMainWidget > div.widgetContent > div.underSearchBox > div:nth-child(1) > div.mainBox.widgetLeftCol > div.mainBoxContent > div.mainParams > div.temperature > div.temp");
        for(Element elem: allH1) {
            System.out.println("Temperatura: "+elem.text());
            zapis.append("Temperatura: \r\n"+elem.text()+"\r\n");
        }
            //wiater
          allH1 = document.select("#weatherMainWidget > div.widgetContent > div.underSearchBox > div:nth-child(1) > div.mainBox.widgetLeftCol > div.mainBoxContent > div.weatherParams > ul > li:nth-child(2) > span.restParamValue");
        for(Element elem: allH1) {
            System.out.println("Wiatr: "+elem.text());
            zapis.append("Wiatr: \r\n"+elem.text()+"\r\n");
        }
            //ciśnienie
          allH1 = document.select("#weatherMainWidget > div.widgetContent > div.underSearchBox > div:nth-child(1) > div.mainBox.widgetLeftCol > div.mainBoxContent > div.weatherParams > ul > li:nth-child(3) > span.restParamValue");
        for(Element elem: allH1) {
           System.out.println("Ciśnienie: "+elem.text());
            zapis.append("Ciśnienie: \r\n"+elem.text()+"\r\n");
        }
            //wilgotność
          allH1 = document.select("#weatherMainWidget > div.widgetContent > div.underSearchBox > div:nth-child(1) > div.mainBox.widgetLeftCol > div.mainBoxContent > div.weatherParams > ul > li:nth-child(5) > span.restParamValue");
        for(Element elem: allH1) {
           System.out.println("Wilgotność: "+elem.text());
            zapis.append("Wilgotność: \r\n"+elem.text()+"\r\n");
        }
             //zachmórzenie
          allH1 = document.select("#weatherMainWidget > div.widgetContent > div.underSearchBox > div:nth-child(1) > div.mainBox.widgetLeftCol > div.mainBoxContent > div.weatherParams > ul > li:nth-child(4) > span.restParamValue");
        for(Element elem: allH1) {
           System.out.println("Zachmórzenie: "+elem.text());
           zapis.append("Zachmórzenie: \r\n"+elem.text()+"\r\n");
        }
            //deszcz
          allH1 = document.select("#weatherMainWidget > div.widgetContent > div.underSearchBox > div:nth-child(1) > div.mainBox.widgetLeftCol > div.mainBoxContent > div.weatherParams > ul > li:nth-child(1) > span.restParamValue");
        for(Element elem: allH1) {
            System.out.println("Opady deszczu: "+elem.text());
            zapis.append("Opady deszczu: \r\n"+elem.text()+"\r\n");
        }
            //śnieg
          allH1 = document.select("#weatherMainWidget > div.widgetContent > div.underSearchBox > div:nth-child(1) > div.mainBox.widgetLeftCol > div.mainBoxContent > div.weatherParams > ul > li:nth-child(6) > span.restParamValue");
        for(Element elem: allH1) {
            System.out.println("Opady śniegu: "+elem.text());
            zapis.append("Opady \nśniegu: \r\n"+elem.text()+"\r\n \r\n");
        }
        //System.out.print("\n\n\n");
        zapis.close();
}
    
    
    
    
    
    
public static void addDir() throws IOException //Tworzy katalog dla nowej miejscowości
{
    Scanner klawiatura = new Scanner(System.in);
    System.out.println("Podaj nazwę miejscowości(bez polskich znakow np.'Wroclaw'): ");
    String nazwaM = klawiatura.nextLine();
    System.out.println("Utworzono Folder");
    Files.createDirectory(Paths.get("DZIENNIK/"+nazwaM));
}


public static void addNote() throws IOException //Dodaje nową notatkę do dziennika
{
    Scanner klawiatura = new Scanner(System.in);
    System.out.println("Gdzie wykonano te obserwacjie? (podaj nazwę miejscowości bez polskich zanków)");
    String nazwaM = klawiatura.nextLine();
    System.out.println("Kiedy wykonano te obserwacjie? (podaj datę wg. wzoru: DD_MM_RRRR)");
    String dataP = klawiatura.nextLine();
    File notatka = new File("DZIENNIK/"+nazwaM+"/"+dataP+".txt");
    
       
    Writer zapis = new BufferedWriter(new FileWriter("DZIENNIK/"+nazwaM+"/"+dataP+".txt", true));
        
        System.out.println("Oto obecna pogoda dla: "+nazwaM);
        pogodynka(nazwaM,dataP);
        
        System.out.println("//Zapisano w notatce//");
        System.out.println("Dodaj opis obserwacji: ");
        String koment;
        while(1>0)
        {koment = klawiatura.nextLine();
        zapis.append(koment+"\r\n");
        if(koment.isBlank())
            break;
        }
        zapis.close();
        System.out.println("//Notatka została dodana//");
    
}

public static void showNotes() throws FileNotFoundException //Pozwala przeglądać dziennik
{
    while(1>0)
    {
    System.out.println("\r\nOto lista miejscowości dla których założono foldery z notatkami\r\n");
    File katalog = new File("./DZIENNIK");
String pliki[] = katalog.list();
    for(int i =0 ; i < pliki.length; i++)
{
System.out.println(pliki[i]);
}
    System.out.println("Który z nich chesz przejrzeć?:");
    System.out.println("1)Wyjście");
    
    Scanner klawiatura = new Scanner(System.in);
    
    String nazwaMiasta = klawiatura.nextLine();
    if(nazwaMiasta.equals("1"))
    {
        break;
    }
    File miasto = new File("./DZIENNIK/"+nazwaMiasta);
    String plikiM[] = miasto.list();
    
    while(1>0)
    {
    System.out.println("\r\nOto zawartość folderu '"+nazwaMiasta+"'\r\n");
    for(int i =0 ; i < plikiM.length; i++)
{
System.out.println(plikiM[i]);
}
    System.out.println("\r\n \r\n");
    System.out.println("1)Wyjście do wyboru folderu\r\n");
    if(klawiatura.nextLine().equals("1"))
    {
        break;
    }
   
    System.out.println("Którą mam wyświetlić?(nazwa razem z .txt!!!!)");
    File notka = new File("./DZIENNIK/"+nazwaMiasta+"/"+klawiatura.nextLine());
    Scanner zPliku = new Scanner(notka);
    while(zPliku.hasNext())
    {
        System.out.println(zPliku.nextLine());
    }
        System.out.println("\r\nWciśnij dowolny klawisz aby wrócić do wyboru notatki.");
        String czekajNaKlik = klawiatura.nextLine();
    }
    }
}
    
    
    
    
    public static void main(String[] args) throws IOException {
    String nazwaM = "DZIENNIK";
    try{Files.createDirectory(Paths.get(nazwaM));}
    catch(Exception e)
    {
        //Do nothing
    }
        while(1>0)
        {    
        System.out.println("\n\r \n\rWitaj \n\rCo chcesz zrobić?:");
        System.out.println("1)Dodać obserwację");
        System.out.println("2)założyć nowy foleder z obserwacjami");
        System.out.println("3)Przeglądać obserwacje");
        System.out.println("4)Wyjście");
        Scanner wybor = new Scanner(System.in);
        
        switch(wybor.nextInt())
        {
            case 1:
                try
                {
            addNote();
                }
                catch(Exception e)
                {
                    System.out.println("BŁĄD OTWARCIA PLIKU!!!");
                }
            break;
            case 2:
                try{
            addDir();
                }
                catch(IOException e)
                {
                    System.out.println("FOLDER O TAKIEJ NAZWIE ISTNIEJE!!!");
                    break;
                }
            break;
            case 3:
            try{showNotes();}
            catch(Exception e)
            {
                System.out.println("Podałeś błędną nazwę!!!");
            }
            break;
            case 4:
            System.exit(0);
        }
      
   
        }
    
    
    
    }
}
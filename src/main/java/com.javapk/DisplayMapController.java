package com.javapk;

import javafx.concurrent.Worker;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class DisplayMapController {

    public Button menuButton;
    public List<Label> coordinatesList;
    public static File selectedDirectory;
    public WebView webMap;

    public void initialize() throws FileNotFoundException {
        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        WebEngine engine = webMap.getEngine();
        engine.setJavaScriptEnabled(true);
        engine.load("http://epsg.io/map#srs=4326&x=19.281006&y=52.536273&z=7&layer=streets");

        engine.getLoadWorker().stateProperty().addListener((observable, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                removePageElements(engine);
            }
        });


        File[] files = selectedDirectory.listFiles();
        int entriesCounter = 0;

        for (File file : files) {
            int i = file.getName().lastIndexOf('.');
            String extension = file.getName().substring(i + 1);

            if (extension.equals("csv")) {
                Scanner fileScanner = new Scanner(file).useDelimiter(";");

                String date = fileScanner.next();
                String title = fileScanner.next();
                String content = fileScanner.next();
                String type = fileScanner.next();
                String east = fileScanner.next();
                String north = fileScanner.next();

                coordinatesList.get(entriesCounter).setText(String.valueOf(entriesCounter + 1) + ". " + east + " " + north);
                entriesCounter++;
            }
        }
    }

    public void displayPoint(MouseEvent mouseEvent) {
        Label  selectedLabel = ((Label) mouseEvent.getSource());
        String selectedPoint  = selectedLabel.getText();

        String[] coordinates = selectedPoint.split(" ");

        String url = "http://epsg.io/map#srs=4326&x=" + coordinates[1] + "&y=" + coordinates[2] + "&z=14&layer=streets";
        System.out.println(url);
        WebEngine engine = webMap.getEngine();
        engine.load(url);

        //Removing not needed elements after page loading
        engine.getLoadWorker().stateProperty().addListener((observable, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                removePageElements(engine);
            }
        });
    }

    public void returnToMenu() throws IOException {
        Parent addEntryLayout = FXMLLoader.load(getClass().getClassLoader().getResource("menu.fxml"));
        Stage stage = (Stage) menuButton.getScene().getWindow();
        ;
        stage.setScene(new Scene(addEntryLayout, 1280, 720));
    }

    public static void removePageElements(WebEngine engine) {
        engine.executeScript("var element =  document.getElementById('navbar-top');\n" +
                "if (typeof(element) != 'undefined' && element != null)\n" +
                "{\n" +
                "  console.log(1);\n" +
                "  document.getElementById(\"navbar-top\").remove();\n" +
                "}");
        engine.executeScript("var element =  document.getElementById('mc-info-container');\n" +
                "if (typeof(element) != 'undefined' && element != null)\n" +
                "{\n" +
                "  console.log(1);\n" +
                "  document.getElementById(\"mc-info-container\").remove();\n" +
                "}");
    }

}

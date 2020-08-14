package com.javapk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MapDisplay extends Application {
    public static void main() {
        Application.launch();
    }

    @Override
    public void start(Stage stage) {
        coordinates();
        display(stage);
    }

    private void coordinates() {
        // Displays map with coordinates from every diary entry
        String[] markers = {"52.424198 17.177124", "52.124198 17.377124"};

        System.out.println("Lista wspolrzednych wszystkich obserwacji, możesz je wyszukać na mapie:");

        for (String marker : markers) {
            System.out.println(marker);
        }
    }

    private void display(Stage stage) {
        String url = "https://www.openstreetmap.org/";

        WebView view = new WebView();
        WebEngine engine = view.getEngine();
        engine.load(url);

        Scene scene = new Scene(view);

        stage.setTitle("Map");
        stage.setScene(scene);
        stage.setWidth(1280);
        stage.show();
    }

}

package com.javapk;

import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class Geolocation extends Application {

    public static void main() {
        Application.launch();
    }

    @Override
    public void start(Stage stage) {
        connect(stage);
    }

    private void connect(Stage stage) {
        String url = "https://epsg.io/map#srs=4326&x=19.281006&y=52.536273&z=7&layer=streets";

        WebView view = new WebView();
        WebEngine engine = view.getEngine();
        engine.load(url);


        // Waiting for page to load
        engine.getLoadWorker().stateProperty().addListener((observable, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                System.out.println("Connected");
            }
        });

        displayPage(stage, view, engine);
    }

    private void getCoordinates(WebEngine engine) {
        String east = (String) engine.executeScript("document.getElementById(\"easting\").value;");
        String north = (String) engine.executeScript("document.getElementById(\"northing\").value;");

        System.out.println("Coordinates: " + north + " " + east);
    }

    private void displayPage(Stage stage, WebView view, WebEngine engine) {
        // VBox vBox = new VBox(view);
        StackPane layout = new StackPane();

        Button select_button = new Button("Select this place");
        select_button.setMaxSize(120, 30);
        select_button.setStyle("-fx-background-color: #e05431; ");

        select_button.setOnAction(actionEvent ->  {
            getCoordinates(engine);
        });

        layout.getChildren().addAll(view, select_button);

        Scene scene = new Scene(layout);

        stage.setTitle("Map");
        stage.setScene(scene);
        stage.setWidth(1280);
        stage.show();
    }
}

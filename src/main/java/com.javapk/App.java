package com.javapk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("menu.fxml"));

        primaryStage.setTitle("Dziennik obserwacji");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }
}

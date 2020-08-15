package com.javapk;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MenuController {
    public Button addEntryButton;
    public Button displayEntriesButton;
    public Button displayMapButton;
    public Button displayPhotosButton;
    public Button loadButton;
    public Button saveButton;
    public Button exitButton;

    private Stage getCurrentStage() {
        return (Stage) addEntryButton.getScene().getWindow();
    }

    public void addEntry() throws IOException {
        Parent addEntryLayout = FXMLLoader.load(getClass().getClassLoader().getResource("addEntry.fxml"));
        Stage stage = getCurrentStage();
        stage.setScene(new Scene(addEntryLayout, 1280, 720));
    }

    public void displayEntries() throws IOException {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Wybierz folder z wpisami dziennika");

        DisplayEntriesController.selectedDirectory = directoryChooser.showDialog(getCurrentStage());

        Parent displayEntriesLayout = FXMLLoader.load(getClass().getClassLoader().getResource("displayEntries.fxml"));
        Stage stage = getCurrentStage();
        stage.setScene(new Scene(displayEntriesLayout, 1280, 720));
    }

    public void displayPhotos() throws IOException {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Wybierz folder z wpisami dziennika");

        DisplayPhotosController.selectedDirectory = directoryChooser.showDialog(getCurrentStage());

        Parent displayEntriesLayout = FXMLLoader.load(getClass().getClassLoader().getResource("displayPhotos.fxml"));
        Stage stage = getCurrentStage();
        stage.setScene(new Scene(displayEntriesLayout, 1280, 720));
    }
    /*
    public void displayMap() {
        Stage stage = getCurrentStage();
        stage.setScene(MapDisplay.getMapScene());
    }*/

    public void exitApplication() {
        Stage stage = getCurrentStage();
        stage.close();
    }
}

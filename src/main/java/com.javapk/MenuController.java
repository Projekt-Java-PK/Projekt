package com.javapk;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

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

    public void exitApplication() {
        Stage stage = getCurrentStage();
        stage.close();
    }
}

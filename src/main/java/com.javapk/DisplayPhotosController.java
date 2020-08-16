package com.javapk;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class DisplayPhotosController {

    public List<Label> dateLabelList;
    public List<Label> typeLabelList;
    public List<ImageView> imageViewList;
    public static File selectedDirectory;
    public Button menuButton;

    public void initialize() throws FileNotFoundException {
        File[] files = selectedDirectory.listFiles();
        int entriesCounter = 0;
        int imagesCounter = 0;

        for (File file : files) {
            int i = file.getName().lastIndexOf('.');
            String extension = file.getName().substring(i + 1);

            if (extension.equals("csv")) {
                Scanner fileScanner = new Scanner(file).useDelimiter(";");

                String date = fileScanner.next();
                String title = fileScanner.next();
                String content = fileScanner.next();
                String type = fileScanner.next();

                dateLabelList.get(entriesCounter).setText(date.substring(0, 10));
                typeLabelList.get(entriesCounter).setText(type);
                entriesCounter++;

            } else if (extension.equals("jpg")) {
                imageViewList.get(imagesCounter).setImage(new Image(file.toURI().toString()));
                imagesCounter++;
            }
        }
    }

    public void returnToMenu() throws IOException {
        Parent addEntryLayout = FXMLLoader.load(getClass().getClassLoader().getResource("menu.fxml"));
        Stage stage = (Stage) menuButton.getScene().getWindow();;
        stage.setScene(new Scene(addEntryLayout, 1280, 720));
    }
}

package com.javapk;

import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;


public class DiaryEntryController {

    public TextField title;
    public TextArea content;
    public ChoiceBox type;
    public Button save;
    public Button choose;
    public File selectedImage;
    public ImageView selectedImageView;
    public TextField coordinateEast;
    public TextField coordinateNorth;

    private Stage getCurrentStage() {
        return (Stage) save.getScene().getWindow();
    }

    public void saveEntry() throws IOException, URISyntaxException {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Wybierz folder z wpisami dziennika");

        File selectedDirectory = directoryChooser.showDialog(getCurrentStage());

        if (selectedImage == null) {
            // Put placeholder if no image was selected
            selectedImage = new File("no-image.png");
        }

        DiaryEntry entry = new DiaryEntry(LocalDateTime.now(), title.getText(), content.getText(),
                (Enum<ObservationType>) type.getSelectionModel().getSelectedItem(), coordinateEast.getText(),
                coordinateNorth.getText(), selectedImage);

        // Save entry in selected directory
        Path selectedImagePath = Paths.get(selectedImage.toString());
        selectedImage.renameTo(new File(selectedImagePath.getParent().toString() + File.separator + entry.getTitle() + "_" + entry.getFormattedDate() + ".jpg"));
        selectedImage = new File(selectedImagePath.getParent().toString() + File.separator + entry.getTitle() + "_" + entry.getFormattedDate() + ".jpg");

        Files.copy(selectedImage.toPath(), selectedDirectory.toPath().resolve(selectedImage.toPath().getFileName()));
        File file = new File(new URI(selectedDirectory.toURI().toString() + entry.getTitle() + "_" + entry.getFormattedDate() + ".csv"));
        file.createNewFile();

        Writer fileWriter = new FileWriter(file);
        fileWriter.write(entry.getCSVData());
        fileWriter.close();

        System.out.println(entry.getCSVData());
    }

    public void FileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Wybierz zdjecie obserwacji");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png")
        );

        selectedImage = fileChooser.showOpenDialog(getCurrentStage());

        if (selectedImage != null) {
            selectedImageView.setImage(new Image(selectedImage.toURI().toString()));
        }
    }

    public void returnToMenu() throws IOException {
        Parent addEntryLayout = FXMLLoader.load(getClass().getClassLoader().getResource("menu.fxml"));
        Stage stage = (Stage) title.getScene().getWindow();
        ;
        stage.setScene(new Scene(addEntryLayout, 1280, 720));
    }

    public void displayMap() {
        String url = "http://epsg.io/map#srs=4326&x=19.281006&y=52.536273&z=7&layer=streets";

        WebView view = new WebView();
        WebEngine engine = view.getEngine();
        engine.load(url);

        // Waiting for page to load
        engine.getLoadWorker().stateProperty().addListener((observable, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                engine.executeScript("var element =  document.getElementById('mc-info-container');\n" +
                        "if (typeof(element) != 'undefined' && element != null)\n" +
                        "{\n" +
                        "  console.log(1);\n" +
                        "  document.getElementById(\"mc-info-container\").remove();\n" +
                        "}");
            }
        });

        StackPane layout = new StackPane();

        Button select_button = new Button("Potwierdź");
        //select_button.setMaxSize(120, 30);
        layout.setMargin(select_button, new Insets(0, 0, 200, 0));
        select_button.setStyle("-fx-background-color: #e05431; ");

        layout.getChildren().addAll(view, select_button);

        Stage stage = new Stage();
        stage.setTitle("Wybierz miejsce obserwacji");
        stage.setScene(new Scene(layout, 860, 640));
        stage.show();

        select_button.setOnAction(actionEvent -> {
            getCoordinates(engine);
            stage.close();
        });
    }

    private void getCoordinates(WebEngine engine) {
        String east = (String) engine.executeScript("document.getElementById(\"easting\").value;");
        String north = (String) engine.executeScript("document.getElementById(\"northing\").value;");

        coordinateEast.setText(east);
        coordinateNorth.setText(north);
    }
}

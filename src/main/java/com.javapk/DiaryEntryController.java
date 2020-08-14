package com.javapk;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

        DiaryEntry entry = new DiaryEntry(LocalDateTime.now(), title.getText(), content.getText(), (Enum<ObservationType>) type.getSelectionModel().getSelectedItem(), selectedImage);

        // Save entry in selected directory
        Path selectedImagePath = Paths.get(selectedImage.toString());
        selectedImage.renameTo(new File(selectedImagePath.getParent().toString() + File.separator + entry.getFormattedDate() + ".jpg"));
        selectedImage = new File(selectedImagePath.getParent().toString() + File.separator + entry.getFormattedDate() + ".jpg");

        Files.copy(selectedImage.toPath(), selectedDirectory.toPath().resolve(selectedImage.toPath().getFileName()));
        File file = new File(new URI(selectedDirectory.toURI().toString() + entry.getFormattedDate() + ".csv"));
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
}

import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class Geolocation extends Application {

    public static void main() {
        Application.launch();
    }

    @Override
    public void start(Stage stage) {
        connect(stage);
    }


    private void connect(Stage stage) {
        String url = "https://mapfling.com/qbx7ezn";

        WebView view = new WebView();
        WebEngine engine = view.getEngine();
        engine.load(url);

        // Waiting for page to load
        engine.getLoadWorker().stateProperty().addListener((observable, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                System.out.println("Connected");
                removePageClutter(stage, view);
                //webDocument = engine.getDocument();
            }
        });

        // if (webDocument.getElementById("sidebdsadzadaar") == null)
        //    System.out.println("taa");
        //Element element = webDocument.getElementById("sidebar");
        //Element element = webDocument.getElementById("sidebar");


    }

    private void removePageClutter(Stage stage, WebView view) {

        VBox vBox = new VBox(view);
        Scene scene = new Scene(vBox, 960, 600);

        stage.setTitle("Map");
        stage.setScene(scene);
        stage.show();
    }
}

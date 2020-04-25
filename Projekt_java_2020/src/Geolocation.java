import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class Geolocation extends Application {

    public static void main() {
        Application.launch();
    }

    @Override
    public void start(Stage stage) {
        connectOSM(stage);
    }

    private void connectOSM(Stage stage) {
        String url = "https://www.openstreetmap.org/#map=11/50.0439/19.9422";

        WebView webView = new WebView();
        webView.getEngine().load(url);

        VBox vBox = new VBox(webView);
        Scene scene = new Scene(vBox, 960, 600);

        stage.setTitle("Map");
        stage.setScene(scene);
        stage.show();
    }
}

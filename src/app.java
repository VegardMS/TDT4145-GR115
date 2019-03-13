package src;
 
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
 
//This file runs the views.fxml file
public class app extends Application {
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(app.class.getResource("views.fxml"));
        Pane root = fxmlLoader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(app.class, args);
    }
}

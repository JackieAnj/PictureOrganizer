package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    static boolean run = false;

    @Override
    public void start(Stage primaryStage) throws Exception {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        Controller.setDirectory(directoryChooser.showDialog(primaryStage));
        if (run) {
            Parent root = FXMLLoader.load(getClass().getResource("application.fxml"));
            primaryStage.setTitle("our application");
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        else{
            System.exit(0);
        }
    }
}

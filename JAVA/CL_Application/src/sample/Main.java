package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        primaryStage.setTitle("Contacts");
        Pane myPane = (Pane)FXMLLoader.load(getClass().getResource
                ("mainWindow.fxml"));
        primaryStage.setScene(new Scene(myPane, 1100, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

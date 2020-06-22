package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
           try{
               Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
               primaryStage.setTitle("FxProject");
               //primaryStage.setScene(new Scene(root, 700, 400));
               Scene scene = new Scene(root, 600, 500);
               primaryStage.setScene(scene);
               scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
               primaryStage.show();
           }
           catch (Exception e){
               e.printStackTrace();
           }
    }

    public static void main(String[] args) {

        launch(args);
    }
}

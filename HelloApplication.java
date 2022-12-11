package com.example.projectdsa;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.io.IOException;
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Search Engine");
        stage.setScene(scene);
        stage.show();
        //confirmation before close window
        stage.setOnCloseRequest(event -> {
            event.consume();//prevent program to close if user click cancel
            close(stage);
        });
    }

    // asking for confirmation before close window
    public void close(Stage stage){
        // Getting confirmation before closing window
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Close");
        alert.setContentText("Do you want to close?");
        if(alert.showAndWait().get()== ButtonType.OK) {
            stage.close();
        }
    }

    //object of avl tree class
    static AvlTree MobilePhpones = new AvlTree();

    static AvlTree Books = new AvlTree();
    static AvlTree Vehicles = new AvlTree();
    static AvlTree wearable = new AvlTree();
    public static void main(String[] args) {
        launch();
    }
}
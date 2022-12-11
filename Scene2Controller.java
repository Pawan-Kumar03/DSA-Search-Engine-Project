package com.example.projectdsa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Scene2Controller {
    @FXML
    Label MobileName;
    @FXML
    Label MobilePrice;

    @FXML
    private AnchorPane finalScene;

    Stage stage;

    public void setText(String sName , String sPrice)
    {
        MobileName.setText(sName);
        MobilePrice.setText(sPrice);
    }

    public void close(ActionEvent event) {
        // Getting confirmation before closing window
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Close");
        alert.setContentText("Do you want to close?");

        if(alert.showAndWait().get()== ButtonType.OK) {
            stage = (Stage) finalScene.getScene().getWindow();
            stage.close();
        }
    }

}

package uz.shop.controllers;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField loginTxt;

    @FXML
    private JFXPasswordField passwordTxt;




    public void onLoginAction(ActionEvent actionEvent) {

    }

    public void initialize(URL location, ResourceBundle resources) {

    }
}

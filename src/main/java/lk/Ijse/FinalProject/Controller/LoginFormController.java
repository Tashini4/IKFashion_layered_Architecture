package lk.Ijse.FinalProject.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.Ijse.FinalProject.dao.Custom.impl.UserDAOImpl;
import lk.Ijse.FinalProject.dto.UserDTO;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {

    @FXML
    private Button btnLogin;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;
    public void initialize(){
        txtUserName.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER){
                txtPassword.requestFocus();
            }
        });
        txtPassword.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER){
                btnLogin.requestFocus();
            }
        });
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        try {
            UserDAOImpl userDAOImpl = new UserDAOImpl();
            Boolean check = userDAOImpl.check(new UserDTO(userName, password));
            if (check) {
                navigationToTheDashboard();
                new Alert(Alert.AlertType.CONFIRMATION, "SuccessFull login").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Sorry! Login can't be find").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void navigationToTheDashboard() throws IOException {
          AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/dashboardForm.fxml"));
          Scene scene = new Scene(rootNode);
          Stage stage= (Stage) this.rootNode.getScene().getWindow();
          stage.setScene(scene);
          stage.centerOnScreen();
          stage.setTitle("Dashboard Form");
        }
    }


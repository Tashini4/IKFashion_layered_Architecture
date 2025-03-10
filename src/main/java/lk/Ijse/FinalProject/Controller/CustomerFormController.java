package lk.Ijse.FinalProject.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
//import lk.Ijse.FinalProject.BO.Custom.impl.CustomerBOImpl;
import lk.Ijse.FinalProject.BO.BOFactory;
import lk.Ijse.FinalProject.BO.custom.CustomerBO;
import lk.Ijse.FinalProject.BO.custom.impl.CustomerBOImpl;
import lk.Ijse.FinalProject.Util.CustomerRegex;
import lk.Ijse.FinalProject.Util.CustomerTextField;
import lk.Ijse.FinalProject.dao.Custom.impl.CustomerDAOImpl;
import lk.Ijse.FinalProject.dto.CustomerDTO;
import lk.Ijse.FinalProject.entity.Customer;
import lk.Ijse.FinalProject.tm.CustomerTM;
//import lk.Ijse.FinalProject.view.tm.CustomerTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class CustomerFormController {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<CustomerTM> tblCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;


   CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.CUSTOMER);

    public void initialize() {
        setCellValueFactory();
        loadAllCustomer();
        setTableAction();

    }
    private void setTableAction() {
        tblCustomer.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) -> {
            txtId.setText(newSelection.getId());
            txtName.setText(newSelection.getName());
            txtEmail.setText(newSelection.getEmail());
            txtContact.setText(newSelection.getContact());
            txtAddress.setText(newSelection.getAddress());
        });
    }

    private void loadAllCustomer() {
        ObservableList<CustomerTM> obList = FXCollections.observableArrayList();

        try {
         List<Customer> customerList = customerBO.getAllCustomer();
            for (Customer c : customerList) {
                CustomerTM tm = new CustomerTM(
                        c.getCustomerId(),
                        c.getCustomerName(),
                        c.getCustomerEmail(),
                        c.getCustomerContact(),
                        c.getCustomerAddress()
                );
                obList.add(tm);
            }
           tblCustomer.setItems(obList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboardForm.fxml"));
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();

    }

    private void clearFields() {

        txtId.setText("");
        txtName.setText("");
        txtEmail.setText("");
        txtContact.setText("");
        txtAddress.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtId.getText();

        try {
            boolean isDeleted = customerBO.deleteCustomer(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String contact = txtContact.getText();
        String address = txtAddress.getText();
        try {
            if (isValied()){}
            boolean isSaved = customerBO.saveCustomer(new Customer(id, name, email, contact, address));
            if (isSaved) {

                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                loadAllCustomer();
                clearFields();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String contact = txtContact.getText();
        String address = txtAddress.getText();

        try {
            boolean isUpdated = customerBO.updateCustomer(new Customer(id, name, email, contact, address));
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
                loadAllCustomer();
                clearFields();

            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }
    public boolean isValied(){
        if (!CustomerRegex.setTextColor(CustomerTextField.ID,txtId))return false;
        if (!CustomerRegex.setTextColor(CustomerTextField.NAME,txtName)) return false;
        if (!CustomerRegex.setTextColor(CustomerTextField.EMAIL,txtEmail)) return false;
        if (!CustomerRegex.setTextColor(CustomerTextField.CONTACT,txtContact)) return false;
        if (!CustomerRegex.setTextColor(CustomerTextField.NAME,txtAddress)) return false;



        return true;
    }
    @FXML
    void txtSearchOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = txtId.getText();
        try {

            Customer customer = customerBO.searchByCustomerId(id);
            if (customer != null) {
                txtId.setText(customer.getCustomerId());
                txtName.setText(customer.getCustomerName());
                txtEmail.setText(customer.getCustomerEmail());
                txtContact.setText(customer.getCustomerContact());
                txtAddress.setText(customer.getCustomerAddress());
            } else {
                new Alert(Alert.AlertType.INFORMATION, "customer not found!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }


    @FXML
    void txtAddressOnKeyReleased(KeyEvent event) {

        CustomerRegex.setTextColor(CustomerTextField.ADDRESS,txtAddress);
    }

    @FXML
    void txtContactOnKeyReleased(KeyEvent event) {

        CustomerRegex.setTextColor(CustomerTextField.CONTACT,txtContact);
    }

    @FXML
    void txtEmailOnKeyReleased(KeyEvent event) {

        CustomerRegex.setTextColor(CustomerTextField.EMAIL,txtEmail);
    }

    @FXML
    void txtIdOnKeyReleased(KeyEvent event) {

        CustomerRegex.setTextColor(CustomerTextField.ID,txtId);
    }

    @FXML
    void txtNameOnKeyReleased(KeyEvent event) {
        CustomerRegex.setTextColor(CustomerTextField.NAME,txtName);

    }
}
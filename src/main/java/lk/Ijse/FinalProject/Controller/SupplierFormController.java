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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import lk.Ijse.FinalProject.BO.BOFactory;
import lk.Ijse.FinalProject.BO.custom.SupplierBO;
import lk.Ijse.FinalProject.dao.Custom.impl.SupplierDAOImpl;
import lk.Ijse.FinalProject.dto.SupplierDTO;
import lk.Ijse.FinalProject.entity.Supplier;
import lk.Ijse.FinalProject.tm.SupplierTM;
//import lk.Ijse.FinalProject.view.tm.SupplierTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SupplierFormController {

    @FXML
    private TableColumn<?, ?> colSupplierAddress;

    @FXML
    private TableColumn<?, ?> colSupplierContact;

    @FXML
    private TableColumn<?, ?> colSupplierEmail;

    @FXML
    private TableColumn<?, ?> colSupplierId;

    @FXML
    private TableColumn<?, ?> colSupplierName;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TableView<SupplierTM> tblSupplier;

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

    SupplierBO supplierBO = (SupplierBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.SUPPLIER);

    public void initialize(){
        setCellValueFactory();
        loadAllSupplier();
        setTableAction();
    }
    private void setTableAction() {
        tblSupplier.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) -> {
            txtId.setText(newSelection.getSupplierId());
            txtName.setText(newSelection.getSupplierName());
            txtEmail.setText(newSelection.getSupplierEmail());
            txtAddress.setText(newSelection.getSupplierAddress());
            txtContact.setText(newSelection.getSupplierContact());
        });
    }

    private void loadAllSupplier() {
        ObservableList<SupplierTM> obList = FXCollections.observableArrayList();

        try {
            List<Supplier> supplierList = supplierBO.getAllSupplier();
            for (Supplier supplier : supplierList) {
                SupplierTM tm = new SupplierTM(
                        supplier.getSupplierId(),
                        supplier.getSupplierName(),
                        supplier.getSupplierEmail(),
                        supplier.getSupplierAddress(),
                        supplier.getSupplierContact()
                        );
                obList.add(tm);
            }
            tblSupplier.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (ClassNotFoundException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }


    private void setCellValueFactory() {
        colSupplierId.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        colSupplierName.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        colSupplierEmail.setCellValueFactory(new PropertyValueFactory<>("supplierEmail"));
        colSupplierAddress.setCellValueFactory(new PropertyValueFactory<>("supplierAddress"));
        colSupplierContact.setCellValueFactory(new PropertyValueFactory<>("supplierContact"));

    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(getClass().getResource("/view/stockForm.fxml"));
        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Stock Form");
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        txtContact.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtId.getText();

        try {
            boolean Delete = supplierBO.deleteSupplier(id);
            if(Delete) {
                new Alert(Alert.AlertType.CONFIRMATION, "supplier deleted!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }catch (ClassNotFoundException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();

        //Supplier supplier = new Supplier(id, name, email , address,contact );

        try {
            boolean Save = supplierBO.saveSupplier(new Supplier(id,name,email,address,contact));
            if (Save) {
                new Alert(Alert.AlertType.CONFIRMATION, "supplier saved!").show();
                loadAllSupplier();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage());
        }catch (ClassNotFoundException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String email= txtEmail.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();


        try {
            boolean Update = supplierBO.updateSupplier(new Supplier(id,name,email,address,contact));
            if(Update) {
                new Alert(Alert.AlertType.CONFIRMATION, "supplier updated!").show();
                loadAllSupplier();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }catch (ClassNotFoundException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

}

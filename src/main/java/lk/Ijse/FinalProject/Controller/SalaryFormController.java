package lk.Ijse.FinalProject.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.Ijse.FinalProject.BO.BOFactory;

/*import lk.Ijse.FinalProject.BO.Custom.SalaryBO;
import lk.Ijse.FinalProject.BO.Custom.impl.EmployeeBOImpl;
import lk.Ijse.FinalProject.BO.Custom.impl.SalaryBOImpl;*/
import lk.Ijse.FinalProject.BO.custom.EmployeeBO;
import lk.Ijse.FinalProject.BO.custom.SalaryBO;
import lk.Ijse.FinalProject.Util.CustomerRegex;
import lk.Ijse.FinalProject.Util.CustomerTextField;
import lk.Ijse.FinalProject.dto.EmployeeDTO;
import lk.Ijse.FinalProject.dto.SalaryDTO;
import lk.Ijse.FinalProject.entity.Employee;
import lk.Ijse.FinalProject.entity.Salary;
import lk.Ijse.FinalProject.tm.SalaryTM;
//import lk.Ijse.FinalProject.view.tm.SalaryTM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SalaryFormController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<String> cmbEmployeeId;

    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colEmployeeId;

    @FXML
    private TableColumn<?, ?> colSalaryId;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<SalaryTM> tblSalary;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtSalaryId;

   SalaryBO salaryBO = (SalaryBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.SALARY);
   EmployeeBO employeeBO = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.EMPLOYEE);

    public void initialize(){
        loadAllSalary();
        setCellValueFactory();
        getEmployeeIds();
        setTableAction();
    }
    private void setTableAction() {
        tblSalary.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) -> {
            txtSalaryId.setText(newSelection.getSalaryId());
            txtDate.setText(newSelection.getDate());
            txtAmount.setText(newSelection.getAmount());
            cmbEmployeeId.setValue(newSelection.getEmployeeId());

        });
    }

    private void getEmployeeIds() {
        ObservableList<String>  obList = FXCollections.observableArrayList();
        try {
            List<String> idList = employeeBO.getEmployeeIds();

            for (String id : idList){
                obList.add(id);
            }
            cmbEmployeeId.setItems(obList);
        }catch (SQLException e){
            showAlert(Alert.AlertType.ERROR, "Error occurred while fetching Items IDs: " + e.getMessage());
        }catch (ClassNotFoundException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void showAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void setCellValueFactory() {
        colSalaryId.setCellValueFactory(new PropertyValueFactory<>("salaryId"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
    }

    private void loadAllSalary() {
        ObservableList<SalaryTM> obList = FXCollections.observableArrayList();

        try {
            List<Salary> salaryList = salaryBO.getAllSalary();
            for (Salary salary : salaryList){
                SalaryTM tm = new SalaryTM(
                        salary.getSalaryId(),
                        salary.getSalaryDate(),
                        salary.getSalaryAmount(),
                        salary.getEmployeeId()
                );
                obList.add(tm);
            }
            tblSalary.setItems(obList);
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }catch (ClassNotFoundException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/dashboardForm.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Dashboard from");

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFeilds();

    }

    private void clearFeilds() {
        txtSalaryId.setText("");
        txtDate.setText("");
        txtAmount.setText("");
        cmbEmployeeId.setValue("");

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String salaryId = txtSalaryId.getText();
        String date = txtDate.getText();
        String amount = txtAmount.getText();
        String employeeId = (String) cmbEmployeeId.getValue();

       // Salary salary = new Salary(salaryId,date,amount,employeeId);

        try {
            boolean Save = salaryBO.saveSalary(new Salary(salaryId,date,amount,employeeId));
            if (Save){
                new Alert(Alert.AlertType.CONFIRMATION,"Salary saved!").show();
                loadAllSalary();
                clearFeilds();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }catch (ClassNotFoundException e){
            new  Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String salaryId = txtSalaryId.getText();
        String date = txtDate.getText();
        String amount = txtAmount.getText();
        String employeeId = (String) cmbEmployeeId.getValue();

        try {
            boolean Update = salaryBO.updateSalary(new Salary(salaryId,date,amount,employeeId));
            if (Update){
                new Alert(Alert.AlertType.CONFIRMATION,"Salary updated!").show();
                loadAllSalary();
                clearFeilds();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }catch (ClassNotFoundException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void cmbEmployeeIdOnAction(ActionEvent event) {
        String id = cmbEmployeeId.getValue();

        try {
            Employee employee = employeeBO.searchByEmployeeId(id);
            cmbEmployeeId.setValue(employee.getEmployeeId());
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void txtSearchOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = txtSalaryId.getText();

        Salary salary = salaryBO.searchBySalaryId(id);
        if (salary != null) {
            txtSalaryId.setText(salary.getSalaryId());
            txtDate.setText(salary.getSalaryDate());
            txtAmount.setText(salary.getSalaryAmount());
            cmbEmployeeId.setValue(salary.getEmployeeId());


        } else {
            new Alert(Alert.AlertType.INFORMATION, "salary not found!").show();
        }
    }

    @FXML
    public void txtSalaryIdOnKeyRelesed(KeyEvent keyEvent) {
       CustomerRegex.setTextColor(CustomerTextField.ID,txtSalaryId);
    }
}

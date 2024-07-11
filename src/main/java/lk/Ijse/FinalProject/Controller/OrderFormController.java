package lk.Ijse.FinalProject.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
//import lk.Ijse.FinalProject.view.tm.CartTM;
import lk.Ijse.FinalProject.BO.BOFactory;
import lk.Ijse.FinalProject.BO.custom.CustomerBO;
import lk.Ijse.FinalProject.BO.custom.ItemBO;
import lk.Ijse.FinalProject.Util.CustomerRegex;
import lk.Ijse.FinalProject.Util.CustomerTextField;
import lk.Ijse.FinalProject.dao.Custom.OrderDetailsDAO;
import lk.Ijse.FinalProject.dao.Custom.PaymentDAO;
import lk.Ijse.FinalProject.dao.Custom.PlaceOrderDAO;
import lk.Ijse.FinalProject.dao.Custom.impl.OrderDAOImpl;
import lk.Ijse.FinalProject.dao.Custom.impl.OrderDetailsDAOImpl;
import lk.Ijse.FinalProject.dao.Custom.impl.PaymentDAOImpl;
import lk.Ijse.FinalProject.db.DbConnection;
import lk.Ijse.FinalProject.dto.OrderDTO;
import lk.Ijse.FinalProject.dto.OrderDetailsDTO;
import lk.Ijse.FinalProject.dto.PaymentDTO;
import lk.Ijse.FinalProject.dto.PlaceOrderDTO;
import lk.Ijse.FinalProject.entity.Customer;
import lk.Ijse.FinalProject.entity.Item;
import lk.Ijse.FinalProject.tm.CartTM;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class OrderFormController {

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnNewCustomer;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private Button btnPrintBill;


    @FXML
    private ComboBox<String> cmbCustomerId;

    @FXML
    private ComboBox<String> cmbItemId;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemId;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private Label lblCustomerName;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblOrderDate;

    @FXML
    private Label lblOrderId;

    @FXML
    private Label lblNetTotal;

    @FXML
    private Label lblPaymentAmount;

    @FXML
    private Label lblPaymentDate;

    @FXML
    private Label lblPaymentId;

    @FXML
    private Label lblQtyOnHand;

    @FXML
    private Label lblUnitPrice;

    @FXML
    private Label lblBalance;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<CartTM> tblPlaceOrder;

    @FXML
    private TextField txtDiscount;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtCash;

    private ObservableList<CartTM> obList = FXCollections.observableArrayList();
    private double discount;

    OrderDAOImpl orderDAO = (OrderDAOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOType.ORDER);
    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.CUSTOMER);
    ItemBO itemBO = (ItemBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.ITEM);

    OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) BOFactory.getBoFactory().getBO(BOFactory.BOType.ORDERDETAILS);
    PaymentDAO paymentDAO = new PaymentDAOImpl();



    public void initialize() {
        getCurrentOrderId();
        setDate();
        getCustomerIds();
        getItemIds();
        setCellValueFactory();
        getCurrentPaymentId();


        addHoverHandlers(btnAddToCart);
        addHoverHandlers(btnBack);
        addHoverHandlers(btnPlaceOrder);
        addHoverHandlers(btnNewCustomer);
        addHoverHandlers(btnPrintBill);

        cmbCustomerId.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                cmbItemId.requestFocus();
            }
        });
        cmbItemId.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                txtQty.requestFocus();
            }
        });
        tblPlaceOrder.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtQty.requestFocus();
            }
        });
    }


    private void addHoverHandlers(Button button) {
        button.setOnMouseEntered(event -> {
            button.setStyle("-fx-background-color: #27f802; -fx-text-fill: white;");
        });
        button.setOnMouseExited(event -> {
            button.setStyle("-fx-background-color: transparent; -fx-text-fill: black;");
        });
        button.setOnMouseExited(event -> {
            button.setStyle("-fx-background-color: transparent; -fx-text-fill: black;");
        });
    }




    private void setDate() {
        LocalDate now = LocalDate.now();
        lblOrderDate.setText(String.valueOf(now));
        lblPaymentDate.setText(String.valueOf(now));
    }

    private void getCurrentOrderId() {
        try {
            String currentId = orderDAO.getCurrentId();

            String nextOrderId = generateNextOrderId(currentId);
            lblOrderId.setText(nextOrderId);

        }catch (SQLException e){
            throw new RuntimeException();
        }catch (ClassNotFoundException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage());
        }
    }

    private String generateNextOrderId(String currentId) {
        if (currentId != null){
           int id = Integer.parseInt((currentId));
           ++id;
           return "0"+id;
        }
        return "01";
    }

    private void getCustomerIds() {
        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<String> idList = customerBO.getIds();
            obList.addAll(idList);
            cmbCustomerId.setItems(obList);
            }catch(SQLException e){
                throw new RuntimeException();
            } catch(ClassNotFoundException e){
                throw new RuntimeException(e);
            }
        }


    private void getItemIds() {
        ObservableList<String>  obList = FXCollections.observableArrayList();
        try {

            List<String> idList =  itemBO.getItemIds();
            obList.addAll(idList);
            cmbItemId.setItems(obList);
        }catch (SQLException e){
            showAlert(Alert.AlertType.ERROR, "Error occurred while fetching Items IDs: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void setCellValueFactory() {
        colItemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btnRemove"));
    }


    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
        String itemId = cmbItemId.getValue();
        String description = lblDescription.getText();
        double unitPrice = Double.parseDouble(((lblUnitPrice.getText())));
        int qty = Integer.parseInt((txtQty.getText()));
        double total = unitPrice * qty;

        JFXButton btnRemove = new JFXButton("remove");
        btnRemove.setCursor(Cursor.HAND);
        btnRemove.setOnAction((e)->{
            ButtonType yes = new ButtonType("yes",ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("no",ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION,"Are you sure to remove?",yes,no).showAndWait();

            if (type.orElse(no) == yes){
                CartTM selectedIndex = tblPlaceOrder.getSelectionModel().getSelectedItem();
                obList.remove(selectedIndex);
                 tblPlaceOrder.refresh();
                 calculateNetTotal();
            }
        });
        for (int i=0; i<tblPlaceOrder.getItems().size();i++){
            if (itemId.equals(colItemId.getCellData(i))){
                CartTM tm = obList.get(i);
                qty += tm.getQty();
                total = qty * unitPrice;
                tm.setQty(qty);
                tm.setTotal(total);

                tblPlaceOrder.refresh();
                calculateNetTotal();
                return;
            }
        }
        CartTM tm = new CartTM(itemId,description,qty,unitPrice,total,btnRemove);
        obList.add(tm);

        tblPlaceOrder.setItems(obList);
        calculateNetTotal();
        txtQty.setText("");
    }

    private void calculateNetTotal() {
        int netTotal = 0;
        for (int i = 0;i<tblPlaceOrder.getItems().size();i++){
            netTotal += (double) colTotal.getCellData(i);
        }
        lblNetTotal.setText(String.valueOf(netTotal));
        double discountedAmount = calculateDiscountedAmount(netTotal); // Calculate discounted amount
        lblPaymentAmount.setText(String.valueOf(discountedAmount));
    }

    private double calculateDiscountedAmount(double amount) {
        return amount * (1- discount);
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Button btn = (Button) event.getSource();
        Stage stage = (Stage) btn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dashboardForm.fxml"));
        Parent rootNode = loader.load();

        Scene scene = new Scene(rootNode);
        stage.setScene(scene);

        stage.show();
    }

    @FXML
    void btnNewOnAction(ActionEvent event) throws IOException {
        Button btn = (Button) event.getSource();
        Stage stage = (Stage) btn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/customerForm.fxml"));
        Parent rootNode = loader.load();
        Scene scene = new Scene(rootNode);
        stage.setScene(scene);

        stage.show();
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) throws SQLException {
        double cash = 0.0;
        try {
            cash = Double.parseDouble(txtCash.getText());
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Please enter a valid cash amount.");
            return;
        }

        double paymentAmount = Double.parseDouble(lblPaymentAmount.getText());
        if (cash < paymentAmount) {
            showAlert(Alert.AlertType.ERROR, "Insufficient cash amount.");
            return;
        }
        String orderId = lblOrderId.getText();
        Date date = Date.valueOf(LocalDate.now());
        String customerId = cmbCustomerId.getValue();
        String paymentId = lblPaymentId.getText();
        double amount = Double.parseDouble((lblPaymentAmount.getText()));

        var order = new OrderDTO(orderId, date, customerId, paymentId);
        List<OrderDetailsDTO> odList = new ArrayList<>();

        for (int i = 0; i < tblPlaceOrder.getItems().size(); i++) {
            CartTM tm = obList.get(i);
            OrderDetailsDTO od = new OrderDetailsDTO(
                    tm.getItemId(),
                    orderId,
                    tm.getQty(),
                    tm.getUnitPrice(),
                    tm.getTotal()
            );
            odList.add(od);
        }
        PaymentDTO payment = new PaymentDTO(paymentId, amount, date);
        PlaceOrderDTO po = new PlaceOrderDTO(order, odList, payment);

            boolean isPlaced = PlaceOrder.placeOrder(po);

            if (isPlaced) {
                obList.clear();
                tblPlaceOrder.setItems(obList);
                lblOrderId.setText("");
                lblPaymentId.setText("");
                lblPaymentAmount.setText("");
                lblDescription.setText("");
                lblUnitPrice.setText("");
                lblQtyOnHand.setText("");
                txtQty.clear();
                txtCash.clear();
                lblBalance.setText("");
                getCurrentOrderId();
                getCurrentPaymentId();

                new Alert(Alert.AlertType.CONFIRMATION, "Order Placed!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Order Placed Unsucessfully!").show();
            }

        }
    @FXML
    void txtDiscountOnAction(ActionEvent event) {
        discount = Double.parseDouble(txtDiscount.getText()) / 100; // Get discount from the TextField
        calculateNetTotal(); // Recalculate net total with discount
    }



    private void getCurrentPaymentId() {
        try {
            String currentId = orderDAO.getPayCurrentId();

            String nextPayId = generateNextPay(currentId);
            lblPaymentId.setText(nextPayId);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateNextPay(String currentId) {
        if (currentId != null && currentId.startsWith("P")) {
            try {
                int idNum = Integer.parseInt(currentId.substring(1)) + 1;
                return "P" + String.format("%03d", idNum);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid current payment ID format");
            }
        }
        return "P001";
    }



    @FXML
    void cmbCustomerIdOnAction(ActionEvent event) {
        String id = cmbCustomerId.getValue();
        try {
            Customer customer = customerBO.searchByCustomerId(id);
            if(customer != null){
                lblCustomerName.setText(customer.getCustomerName());
            }else {

                lblCustomerName.setText("Customer not Found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void cmbItemIdOnAction(ActionEvent event) {
        String id = String.valueOf(cmbItemId.getValue());
        try {
            Item item = itemBO.searchByItemId(id);
            if (item != null) {
                lblDescription.setText(item.getDescription());
                lblUnitPrice.setText(String.valueOf(item.getPrice()));
                lblQtyOnHand.setText(String.valueOf(item.getQtyOnHand()));

            }else {
                lblDescription.setText("not Found");
                lblUnitPrice.setText("not found");
                lblQtyOnHand.setText("not Found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void txtQtyOnAction(ActionEvent actionEvent) {

        btnAddToCartOnAction(actionEvent);
    }
    @FXML
    void txtCashOnAction(ActionEvent event) {
        calculateBalance();
    }

    private void calculateBalance() {
        double cash = 0.0;
        try {
            cash = Double.parseDouble(txtCash.getText());
        } catch (NumberFormatException e) {
            lblBalance.setText("Invalid input");
            return;
        }

        double paymentAmount = Double.parseDouble(lblPaymentAmount.getText());
        double balance = cash - paymentAmount;
        lblBalance.setText(String.valueOf(balance));
    }
    @FXML
    void btnPrintBillOnAction(ActionEvent event) throws JRException, SQLException {

          /*  JasperDesign jasperDesign = JRXmlLoader.load("src/main/resources/reports/Report.jrxml");

            // Create and set the query
            JRDesignQuery jrDesignQuery = new JRDesignQuery();
            jrDesignQuery.setText("SELECT o.orderId, c.customerId, i.itemId, od.qty, od.unitPrice, od.total " +
                    "FROM orders o " +
                    "JOIN customers c ON o.customerId = c.customerId " +
                    "JOIN orderDetails od ON o.orderId = od.orderId " +
                    "JOIN items i ON od.itemId = i.itemId " +
                    "WHERE o.orderId = ( " +
                    "SELECT MAX(orderId) " +
                    "FROM orders );");
            ((JasperDesign) jasperDesign).setQuery(jrDesignQuery);

            // Compile the Jasper report
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            Map<Double, Object> discout= new HashMap<>();
            double discount = Double.parseDouble(txtDiscount.getText());
            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DbConnection.getDbConnection().getConnection);

            // View the report
            JasperViewer.viewReport(jasperPrint, false);*/
        }
        @FXML
    void txtQtyOnKeyReleased(KeyEvent event) {

        CustomerRegex.setTextColor(CustomerTextField.NUMBER,txtQty);
    }


    public void txtCashOnKeyRelesed(KeyEvent keyEvent) {
        calculateBalance();
    }
}


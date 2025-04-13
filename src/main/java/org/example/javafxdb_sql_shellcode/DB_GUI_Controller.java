package org.example.javafxdb_sql_shellcode;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static org.example.javafxdb_sql_shellcode.App.cdbop;


public class DB_GUI_Controller implements Initializable {

    private final ObservableList<Person> data =
            FXCollections.observableArrayList(
                    new Person(1, "Jacob", "Smith", "CPIS", "CS", "Test"),
                    new Person(2, "Jacob2", "Smith1", "CPIS1", "CS", "Test")

            );


    @FXML
    TextField name, email, phone, address, password;
    //TextField first_name, last_name, department, major;
    @FXML
    private TableView<Person> tv;
    @FXML
    private TableColumn<Person, Integer> tv_id;
    @FXML
    private TableColumn<Person, String> tv_fn, tv_ln, tv_dept, tv_major;

    @FXML
    ImageView img_view;

    // Display Button
    @FXML
    void displayButton(ActionEvent event) {
        // Setup cell factories
        ObservableList<Person> userList = FXCollections.observableArrayList(cdbop.getAllUsersAsPersons());
        tv.setItems(userList);
    }

    // Insert Button
    @FXML
    void insertButton(ActionEvent event) {
        String nameVal = name.getText();
        String emailVal = email.getText();
        String phoneVal = phone.getText();
        String addressVal = address.getText();
        String passwordVal = password.getText();

        if (nameVal.isEmpty() || emailVal.isEmpty() || passwordVal.isEmpty()) {
            System.out.println("Name, Email, and Password are required.");
            return;
        }

        cdbop.insertUser(nameVal, emailVal, phoneVal, addressVal, passwordVal);

        displayButton(event);
        clearForm();
    }

    // Query Button
    @FXML
    void queryButton(ActionEvent event) {
        String nameVal = name.getText();

        if (nameVal.isEmpty()) {
            System.out.println("Enter a name to search.");
            return;
        }

        ObservableList<Person> matchedUsers = FXCollections.observableArrayList(cdbop.queryUsersByName(nameVal));

        if (matchedUsers.isEmpty()) {
            System.out.println("No matching users found.");
        }

        tv.setItems(matchedUsers);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tv_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tv_fn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tv_ln.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tv_dept.setCellValueFactory(new PropertyValueFactory<>("dept"));
        tv_major.setCellValueFactory(new PropertyValueFactory<>("major"));
    }

    @FXML
    protected void clearForm() {
        name.clear();
        email.clear();
        phone.clear();
        address.clear();
        password.clear();
    }

    @FXML
    protected void closeApplication() {
        System.exit(0);
    }

    @FXML
    protected void deleteRecord() {
        Person p= tv.getSelectionModel().getSelectedItem();
        data.remove(p);
    }

    @FXML
    protected void showImage() {
        File file= (new FileChooser()).showOpenDialog(img_view.getScene().getWindow());
        if(file!=null){
            img_view.setImage(new Image(file.toURI().toString()));

        }
    }

    public void connectButton(ActionEvent actionEvent) {
        cdbop.connectToDatabase();
    }

    public void editRecord(ActionEvent actionEvent) {
    }

    public void addNewRecord(ActionEvent actionEvent) {
    }
}
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
    TextField first_name, last_name, department, major;
    @FXML
    private TableView<Person> tv;
    @FXML
    private TableColumn<Person, Integer> tv_id;
    @FXML
    private TableColumn<Person, String> tv_fn, tv_ln, tv_dept, tv_major;

    @FXML
    ImageView img_view;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //tv_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        //tv_fn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        //tv_ln.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        //tv_dept.setCellValueFactory(new PropertyValueFactory<>("dept"));
        //tv_major.setCellValueFactory(new PropertyValueFactory<>("major"));


        //tv.setItems(data);
    }


    @FXML
    protected void clearForm() {
        first_name.clear();
        last_name.setText("");
        department.setText("");
        major.setText("");
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
package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AllStudentRegistered  implements Initializable 
{
    public TableColumn name_of_father;
    public TableColumn name_of_mother;
    public TableColumn gender_of_student;
    public TableColumn date_of_birth;
    public TableColumn address;
    public TableColumn extra_info;
    public TableView main_data_table;
    public TableColumn first_name_of_student;
    public TableColumn last_name_of_student;
    public ArrayList<student_base_class> all_student_info= new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        display_data_class obj= new display_data_class();
        obj.selectAll();
        all_student_info= obj.return_array();



            first_name_of_student.setCellValueFactory(new PropertyValueFactory<student_base_class, String>("first_name"));
            last_name_of_student.setCellValueFactory(new PropertyValueFactory<student_base_class, String>("last_name"));
            name_of_father.setCellValueFactory(new PropertyValueFactory<student_base_class, String>("father_name"));
            name_of_mother.setCellValueFactory(new PropertyValueFactory<student_base_class, String>("mother_name"));
            gender_of_student.setCellValueFactory(new PropertyValueFactory<student_base_class, String>("gender"));
            date_of_birth.setCellValueFactory(new PropertyValueFactory<student_base_class, String>("dob"));
            address.setCellValueFactory(new PropertyValueFactory<student_base_class, String>("address"));
            extra_info.setCellValueFactory(new PropertyValueFactory<student_base_class, String>("info"));


        main_data_table.getItems().setAll(all_student_info);

    }

}

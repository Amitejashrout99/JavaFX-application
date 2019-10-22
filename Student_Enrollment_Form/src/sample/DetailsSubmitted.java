package sample;

import javafx.fxml.Initializable;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DetailsSubmitted implements Initializable {
    public Text name_of_student;
    public Text name_of_father;
    public Text name_of_mother;
    public Text gender;
    public Text date_of_birth;
    public Text address;

    public ArrayList<student_base_class> all_student_data= new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        display_data_class obj= new display_data_class();
        obj.selectAll();
        all_student_data=obj.return_array();

        student_base_class last_obj= all_student_data.get(all_student_data.size()-1);

        name_of_student.setText("Name of the student submitted: "+ last_obj.first_name+" "+last_obj.last_name);
        name_of_student.setFont(new Font("Arial", 24));
        name_of_student.setLineSpacing(1);
        name_of_student.setLayoutX(70);
        name_of_student.setLayoutY(200);

        name_of_father.setText("Name of Father submitted: "+last_obj.father_name);
        name_of_father.setFont(new Font("Arial", 24));
        name_of_father.setLineSpacing(1);
        name_of_father.setLayoutX(70);
        name_of_father.setLayoutY(300);

        name_of_mother.setText("Name of mother submitted: "+last_obj.mother_name);
        name_of_mother.setFont(new Font("Arial", 24));
        name_of_mother.setLineSpacing(1);
        name_of_mother.setLayoutX(70);
        name_of_mother.setLayoutY(400);

        gender.setText("Gender selected: "+ last_obj.gender);
        gender.setFont(new Font("Arial", 24));
        gender.setLineSpacing(1);
        gender.setLayoutX(70);
        gender.setLayoutY(500);

        date_of_birth.setText("Date of Birth of Student provided: "+ last_obj.dob);
        date_of_birth.setFont(new Font("Arial", 24));
        date_of_birth.setLineSpacing(1);
        date_of_birth.setLayoutX(70);
        date_of_birth.setLayoutY(600);

        address.setText("Address of Student given: "+ last_obj.address);
        address.setFont(new Font("Arial", 24));
        address.setLineSpacing(1);
        address.setLayoutX(70);
        address.setLayoutY(700);


    }
}

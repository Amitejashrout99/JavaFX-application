package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application {


    @FXML
    MenuBar menuBar;

    public static String gender_name;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("home_page.fxml"));
        primaryStage.setTitle("Student Enrollment Form");

        javafx.scene.control.Menu menu= new Menu("Select your choice");
        MenuItem menuItem11= new MenuItem("Submit Details for new Student");
        MenuItem menuItem22= new MenuItem("View Your Submission");
        MenuItem menuItem33= new MenuItem("View Details Of Student Enrolled ");


        menu.getItems().add(menuItem11);
        menu.getItems().add(menuItem22);
        menu.getItems().add(menuItem33);


        menuBar= new MenuBar();
        menuBar.getMenus().add(menu);

        menuBar.setLayoutX(850);
        menuBar.setLayoutY(50);

        menuItem22.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    Parent root1 = FXMLLoader.load(getClass().getResource("details_submitted.fxml"));
                    primaryStage.setTitle("Student Details Submitted");

                    Group last_detail_submitted= new Group(root1);
                    Label form_banner_details= new Label("Details Of your Submission");
                    form_banner_details.setLayoutX(350);
                    form_banner_details.setLayoutY(50);
                    form_banner_details.setAlignment(Pos.CENTER);
                    form_banner_details.setFont(new Font("Arial", 24));
                    form_banner_details.setUnderline(true);

                    last_detail_submitted.getChildren().add(form_banner_details);


                    Button go_to_home= new Button("Click to go back to main screen");
                    go_to_home.setId("hyperlink_1");
                    go_to_home.setLayoutX(410);
                    go_to_home.setLayoutY(120);
                    go_to_home.setAlignment(Pos.CENTER);
                    go_to_home.setMaxWidth(200);
                    go_to_home.setMaxHeight(80);
                    go_to_home.setStyle("-fx-border-radius: 10px");
                    go_to_home.setStyle("-fx-background-color: darkorange");


                    last_detail_submitted.getChildren().add(go_to_home);


                    primaryStage.setScene(new Scene(last_detail_submitted, 1000, 700));
                    primaryStage.show();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

            }
        });



        menuItem33.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    Parent root2 = FXMLLoader.load(getClass().getResource("all_student_registered.fxml"));
                    primaryStage.setTitle("Details of Students enrolled till now");

                    Group all_registered_scene= new Group(root2);
                    Label form_banner_details= new Label("Details Of Student Enrolled Till Now");
                    form_banner_details.setLayoutX(350);
                    form_banner_details.setLayoutY(50);
                    form_banner_details.setAlignment(Pos.CENTER);
                    form_banner_details.setFont(new Font("Arial", 24));
                    form_banner_details.setUnderline(true);

                    all_registered_scene.getChildren().add(form_banner_details);

                    Button go_to_home= new Button("Click to go back to main screen");
                    go_to_home.setId("hyperlink_1");
                    go_to_home.setLayoutX(430);
                    go_to_home.setLayoutY(120);
                    go_to_home.setAlignment(Pos.CENTER);
                    go_to_home.setMaxWidth(200);
                    go_to_home.setMaxHeight(80);
                    go_to_home.setStyle("-fx-border-radius: 10px");
                    go_to_home.setStyle("-fx-background-color: darkorange");


                    all_registered_scene.getChildren().add(go_to_home);



                    primaryStage.setScene(new Scene(all_registered_scene, 1000, 700));
                    primaryStage.show();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });

        GridPane root_grid= new GridPane();



        //ImageView logoimage= new ImageView("logo_Image");
        Label form_banner= new Label("Student Admission Form for new Session");
        form_banner.setLayoutX(350);
        form_banner.setLayoutY(50);
        form_banner.setAlignment(Pos.CENTER);
        form_banner.setFont(new Font("Arial", 24));

        Group parent_image= new Group(root);
        parent_image.getChildren().add(form_banner);


        parent_image.getChildren().add(menuBar);


        Text first_name= new Text("First Name");
        TextField first_name_value= new TextField();

        first_name.setId("first_name");
        first_name.setX(20);
        first_name_value.setPromptText("Enter Student's First Name");
        first_name.setFont(new Font("Arial", 20));
        first_name.setStyle("-fx-padding:10;");
        root_grid.add(first_name,0,13);
        root_grid.add(first_name_value,7,13,10,1);
        root_grid.setHgap(10);
        root_grid.setVgap(10);


        Text last_name= new Text("Last Name");
        TextField last_name_value= new TextField();
        last_name_value.setPromptText("Enter Student's Last Name");
        last_name.setId("last_name");
        last_name.setFont(new Font("Arial", 20));
        last_name.setStyle("-fx-padding:10;");
        root_grid.add(last_name,0,16);
        root_grid.add(last_name_value,7,16,10,1);


        Text father_name= new Text("Father's Name");
        TextField father_name_value= new TextField();
        father_name_value.setPromptText("Enter Father's Name");
        father_name.setId("father_name");
        father_name.setFont(new Font("Arial", 20));
        father_name.setStyle("-fx-padding:10;");
        root_grid.add(father_name,0,19);
        root_grid.add(father_name_value,7,19,10,1);

        Text mother_name= new Text("Mother's Name");
        TextField mother_name_value= new TextField();
        mother_name.setId("mother_name");
        mother_name_value.setPromptText("Enter Mother's Name");
        mother_name.setFont(new Font("Arial", 20));
        mother_name.setStyle("-fx-padding:10;");
        root_grid.add(mother_name,0,22);
        root_grid.add(mother_name_value,7,22,10,2);

        Text address= new Text("Current Address");
        TextField address_value= new TextField();
        address_value.setPromptText("Enter current Address");
        address.setId("student_address");
        address.setFont(new Font("Arial", 20));
        address.setStyle("-fx-padding:10;");
        root_grid.add(address,0,25);
        root_grid.add(address_value,0,27,18,2);

        Text date_of_birth= new Text("Date Of Birth");
        TextField date_of_birth_value= new TextField();
        date_of_birth_value.setPromptText("Enter DOB");
        date_of_birth.setId("dob");
        date_of_birth.setFont(new Font("Arial", 20));
        date_of_birth.setStyle("-fx-padding:10;");
        root_grid.add(date_of_birth,0,30);
        root_grid.add(date_of_birth_value,7,30,10,2);


        Text gender= new Text("Gender");
        MenuItem menuItem1= new MenuItem("Male");
        MenuItem menuItem2= new MenuItem("Female");
        MenuItem menuItem3= new MenuItem("Transgender");

        MenuButton menuButton= new MenuButton("Select Gender",null,menuItem1,menuItem2,menuItem3);


        menuItem1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                gender_name="Male";
            }
        });

        menuItem2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                gender_name="Female";
            }
        });

        menuItem3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gender_name="Transgender";
            }
        });

        gender.setFont(new Font("Arial", 20));
        root_grid.add(gender,0,33);
        root_grid.add(menuButton,7,33);


        Text personal_desc= new Text("Personal Description");
        personal_desc.setId("per_desc");
        TextField personal_desc_value= new TextField();

        personal_desc_value.setPromptText("Write Few Lines about Yourself");
        personal_desc.setFont(new Font("Arial", 20));
        date_of_birth.setStyle("-fx-padding:10;");
        root_grid.add(personal_desc,0,36);
        root_grid.add(personal_desc_value,0,38,18,2);


        Button submit_button= new Button("Click to submit the Details");
        submit_button.setId("submission");
        submit_button.setMaxWidth(200);
        submit_button.setMaxHeight(80);
        submit_button.setStyle("-fx-border-radius: 10px");
        submit_button.setStyle("-fx-background-color: darkorange");
        root_grid.add(submit_button,15,42,4,2);



        root_grid.getStylesheets().add("style.css");

        parent_image.getChildren().add(root_grid);


        submit_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    String first_name= first_name_value.getText();
                    String last_name= last_name_value.getText();
                    String father_name= father_name_value.getText();
                    String mother_name= mother_name_value.getText();
                    String address= address_value.getText();
                    String dob= date_of_birth_value.getText();
                    String gender= gender_name;
                    String personal_desc= personal_desc_value.getText();

                    Connection secondary_conn= connect();

                    insert_data insert_data= new insert_data(first_name,
                            last_name,father_name,mother_name,gender,dob,address,
                            personal_desc);

                    insert_data.insert(secondary_conn);
                    //display_data_class display_data_class= new display_data_class();
                    //display_data_class.selectAll();

                    //database_connection obj= new database_connection();
                    //obj.connect();
                    //obj.insert_data(first_name,father_name,mother_name,dob,gender,personal_desc,address,last_name);
                }
                catch (Exception e)
                {
                    e.getMessage();
                }

            }
        });





        Scene scene= new Scene(parent_image,1000,700);

        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static Connection connect()
    {
        Connection conn = null;
        try
        {
            String url= "jdbc:sqlite:C:/Users/HP/IdeaProjects/Student_Enrollment_Form/student_info.db";
            conn= DriverManager.getConnection(url);
            System.out.println("connection has been established");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public static void main(String[] args) throws SQLException
    {
        //database_creation database_creation= new database_creation();
        //database_creation.createNewDatabase("student_info.db");
        Connection main_conn= connect();
        //table_creation new_table= new table_creation();
        //new_table.create_table(main_conn);
        launch(args);
    }
}

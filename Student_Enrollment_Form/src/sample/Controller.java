package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.*;

public class Controller implements  Initializable{


    @FXML
    public ImageView logo_Image;
    public MenuBar menu_bar;


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        try
        {
            Image logo= new Image(new FileInputStream("res/userprofile.png"));
            logo_Image.setImage(logo);
            logo_Image.setX(50);
            logo_Image.setY(50);





        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}

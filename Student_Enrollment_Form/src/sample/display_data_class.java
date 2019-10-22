package sample;

import java.sql.*;
import java.util.ArrayList;

public class display_data_class
{

    public ArrayList<student_base_class>all_students= new ArrayList<>();

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






    public void selectAll(){
        String sql = "SELECT * FROM new_student_info";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next())
            {
                /*System.out.println(rs.getString("student_first_name"));
                System.out.println(rs.getString("student_last_name"));
                System.out.println(rs.getString("student_father_name"));
                System.out.println(rs.getString("student_mother_name"));
                System.out.println(rs.getString("student_gender"));
                System.out.println(rs.getString("student_dob"));
                System.out.println(rs.getString("student_address"));
                System.out.println(rs.getString("student_info"));*/

                student_base_class obj= new student_base_class(rs.getString("student_first_name"),
                        rs.getString("student_last_name"),
                        rs.getString("student_father_name"),
                        rs.getString("student_mother_name"),
                        rs.getString("student_gender"),
                        rs.getString("student_dob"),
                        rs.getString("student_address"),
                        rs.getString("student_info"));

                all_students.add(obj);

            }
            System.out.println(all_students);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<student_base_class> return_array()
    {
        System.out.println(all_students);
        return all_students;
    }

}

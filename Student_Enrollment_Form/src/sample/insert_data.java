package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insert_data
{
    public static String first_name;
    public static String last_name;
    public static String father_name;
    public static String mother_name;
    public static String gender;
    public static String dob;
    public static String address;
    public static String info;


    public insert_data(String first_name, String last_name, String father_name, String mother_name, String gender, String dob, String address, String info) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.father_name = father_name;
        this.mother_name = mother_name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.info = info;
    }

    public static void show_data()
    {
        System.out.println(first_name);
        System.out.println(last_name);
        System.out.println(father_name);
        System.out.println(mother_name);
        System.out.println(gender);
        System.out.println(dob);
        System.out.println(address);
        System.out.println(info);

    }


    public static void insert(Connection conn1) throws SQLException
    {
        String sql="insert into new_student_info(student_first_name, student_last_name, student_father_name, student_mother_name, student_gender, student_dob, student_address, student_info) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = conn1;)
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,first_name);
            pstmt.setString(2,last_name);
            pstmt.setString(3,father_name);
            pstmt.setString(4,mother_name);
            pstmt.setString(5,gender);
            pstmt.setString(6,dob);
            pstmt.setString(7,address);
            pstmt.setString(8,info);
            pstmt.executeUpdate();
            System.out.println("Row added");
            pstmt.close();
            conn1.close();

        }
        catch (SQLException e)
        {
            System.out.println("Error" +e.getMessage());
        }
    }
}

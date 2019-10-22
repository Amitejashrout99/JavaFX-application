package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class table_creation
{
    public static void create_table(Connection conn2)throws SQLException
    {
        String query2= "create table new_student_info\n" +
                "(\n" +
                "    student_first_name  varchar\n" +
                "        constraint new_student_info_pk\n" +
                "            primary key,\n" +
                "    student_last_name   varchar,\n" +
                "    student_father_name varchar,\n" +
                "    student_mother_name varchar,\n" +
                "    student_gender      varchar,\n" +
                "    student_dob         varchar,\n" +
                "    student_address     varchar,\n" +
                "    student_info        varchar\n" +
                ")";

        try (Connection conn = conn2;)
        {
            Statement stmt= conn.createStatement();
            stmt.executeUpdate(query2);
            stmt.close();
            conn2.close();
            System.out.println("Table Created");
        }
        catch (SQLException e)
        {
            System.out.println("Creation Table Error"+ e.getMessage());
        }
    }

}

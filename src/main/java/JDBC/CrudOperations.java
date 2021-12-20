package JDBC;

import Records.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudOperations {

    static final String url = "jdbc:postgresql://localhost:5432/University";
    static final String username = "postgres";
    static final String pwd = "postgres";

    public static void main(String[] args) throws SQLException {
//----CRUD Operation methods
        //selectOperations();
        //insertOperation();
        //deleteOperation();
        //updateOperations();
    }



//------select operation to display the data of the table
    public static void selectOperations() throws SQLException {

//------first way
        try (Connection con = DriverManager.getConnection(url, username, pwd);
             PreparedStatement pst = con.prepareStatement("Select * from student")
        ) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("\n Dataa ......................................");
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4) + " " + rs.getBoolean(5) + " " + rs.getString(6));


//------second way
           /* String sql1 = "Select * from student";
               try (Connection con = DriverManager.getConnection(url, username, pwd);
               PreparedStatement pst = conn.prepareStatement(sql1)
               ) {
                  ResultSet resultSet = preparedStatement.executeQuery();
                while(rs.next()) {
                System.out.print("ID: " + rs.getInt(1));
                System.out.print(", Name: " + rs.getString(2));
                System.out.print(", Surname: " + rs.getString(3));
                System.out.println(", Age: " + rs.getInt(4));
                System.out.println(", Gender: " + rs.getString(5));
                System.out.println(", GroupId: " + rs.getString(6));
           */
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    //insert operation to insert a record in existing table
    public static void insertOperation() throws SQLException {

//------first way
        String sql = "insert into student values(139,'Shweta','Pathak',26,false,'Grp = 3.3')";
        try (Connection con = DriverManager.getConnection(url, username, pwd);
             PreparedStatement pst = con.prepareStatement(sql)) {


//------second way
            // String sql1 = "INSERT INTO student (\"id\", \"name\", \"surname\", \"age\", \"Gender\", \"GroupId\") " +" VALUES (?, ?, ?, ?,?,?)";
            /*try (Connection con = DriverManager.getConnection(url,username,pwd);
                 PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, 139);
                pst.setString(2, "Shweta");
                pst.setString(3, "Pathak");
                pst.setInt(4, 26);
                pst.setInt(5, false);
                pst.setBoolean(6, "Grp = 3.3");
*/

            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new student was inserted successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



//------delete operation to delete a record from existing table
    public static void deleteOperation() throws SQLException {

//------first way
        String sql = "Delete from student where stud_id = 139";
        try (Connection con = DriverManager.getConnection(url, username, pwd);
             PreparedStatement pst = con.prepareStatement(sql)
        ) {

//------second way
       /* String sql1 = "Delete from student where stud_id = 139";
        try (Connection con = DriverManager.getConnection(url,username,pwd);
             PreparedStatement pst = con.prepareStatement(sql1)) {
            preparedStatement.setInt(1,140);
*/
            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A student was deleted successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



//------update operation to update records in existing table
    public static void updateOperations() throws SQLException {

//------first way
        String sql = "UPDATE student " + "SET stud_age = 26 WHERE stud_id = 137";
        try (Connection conn = DriverManager.getConnection(url, username, pwd);
             PreparedStatement pst = conn.prepareStatement(sql)
        ) {

//------second way
       /* String sql1 = "UPDATE student " + "SET stud_age = 27 WHERE stud_id = 137";
           try (Connection con = DriverManager.getConnection(url,username,pwd);
           PreparedStatement pst = con.prepareStatement(sql1)){
           preparedStatement.setString(1,"Pathak");
           preparedStatement.setInt(2,28);
           preparedStatement.setInt(3,"Grp = 3.3");
         */

            int rowsUpdated = pst.executeUpdate();
           /* if (rowsUpdated > 0) {
                System.out.println("A  student was updated successfully!");
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

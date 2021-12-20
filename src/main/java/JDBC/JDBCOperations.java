package JDBC;
import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.Properties;


public class JDBCOperations {

    static final String url = "jdbc:postgresql://localhost:5432/jdbcexample2";
    static final String username = "postgres";
    static final String pwd = "postgres";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //createdb();
        //dropdb();
        //createtable();
        //droptable();
        //insertrecords();
        //updaterecords();
        //deleterecords();
        //whereclause();


/*      //basic syntax for creating
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url,username,pwd);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("create database JDBCExample2");
        rs.close();
        st.close();
        con.close();
*/
    }



    private static void whereclause() {

        try(Connection con = DriverManager.getConnection(url, username, pwd);
            Statement st = con.createStatement();
            ) {
            System.out.println("Fetching records without condition...");

            ResultSet rs = st.executeQuery("Select * from student");
            while(rs.next()){
                //Display values
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Name: " + rs.getString("name"));
                System.out.print(", Surname: " + rs.getString("surname"));
                System.out.println(", Age: " + rs.getInt("age"));
                System.out.println(", Gender: " + rs.getString("gender"));
            }

            System.out.println("Fetching records with condition...");
            String query = "SELECT id, name, surname, age,gender FROM student" +
                    " WHERE age >= 24 ";
            rs = st.executeQuery(query);

            while(rs.next()){
                //Display values
                System.out.print("ID: " + rs.getInt(1));
                System.out.print(", Name: " + rs.getString(2));
                System.out.print(", Surname: " + rs.getString(3));
                System.out.println(", Age: " + rs.getInt(4));
                System.out.println(", Gender: " + rs.getString(5));
            }rs.close();
            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


    private static void deleterecords() {
        try(Connection con = DriverManager.getConnection(url, username, pwd);
            Statement st = con.createStatement();
        ) {
            String query = "DELETE FROM student WHERE id in (101,11) ";
            st.executeUpdate(query);
            ResultSet rs = st.executeQuery("select * from student");
            while(rs.next()){
                //Display values
                System.out.print("ID: " + rs.getInt(1));
                System.out.print(", Name: " + rs.getString("name"));
                System.out.print(", Surname: " + rs.getString(3));
                System.out.println(", Age: " + rs.getInt("age"));
                System.out.println(", Gender: " + rs.getString(5));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private static void updaterecords() {
        try(Connection con = DriverManager.getConnection(url, username, pwd);
            Statement st = con.createStatement();
        ) {
            String query = "UPDATE student " +
                    "SET age = 27 WHERE id in (11, 101)";

            st.executeUpdate(query);
            ResultSet rs = st.executeQuery("Select * from student order by id asc");
            while(rs.next()){
                //Display values
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void insertrecords() throws SQLException {

        try (Connection con = DriverManager.getConnection(url, username, pwd);
            Statement st=con.createStatement();
            ){
            System.out.println("Inserting records into the table");
            String sql = "INSERT INTO student VALUES (11, 'Prabhat', 'Singh', 24,'male')";
            st.executeUpdate(sql);
            sql = "INSERT INTO student VALUES (12, 'Namrata', 'Raut', 25,'female')";
            st.executeUpdate(sql);
            sql = "INSERT INTO student VALUES (13, 'Ravi', 'Raj', 26,'female')";
            st.executeUpdate(sql);
            sql = "INSERT INTO student VALUES(14, 'Revati ', 'Navgire', 23,'female')";
            st.executeUpdate(sql);
            sql = "INSERT INTO student VALUES(15, 'Abhishek', 'Kumar', 26,'male')";
            st.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void droptable() throws SQLException {

        try (Connection con = DriverManager.getConnection(url, username, pwd);
             Statement st = con.createStatement();
        ){
            String query = "Drop table student2";
            st.executeQuery(query);
            System.out.println("Drop table successfully");
        }
    catch(SQLException e){
        e.printStackTrace();
    }

}

    private static void createtable() {
        try {
            Connection con = DriverManager.getConnection(url,username,pwd);
            Statement st = con.createStatement();
            {
                String query = "CREATE TABLE student " +
                         "(id int not null," +
                        "name varchar(50)," +
                        "surname varchar(50)," +
                        "age int ,"+
                        "gender varchar(10),"+
                        "Primary key(id))";
                st.executeQuery(query);
                System.out.println("Table created successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    //drop database
    private static void dropdb() {

        try(Connection con = DriverManager.getConnection(url,username,pwd);
            Statement st = con.createStatement();
        ) {
            String sql = "DROP DATABASE jdbcexample";
            st.executeUpdate(sql);
            System.out.println("Database drop successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   //create database
    private static void createdb() {
        try(Connection con = DriverManager.getConnection(url,username,pwd);
            Statement stmt = con.createStatement();
        ) {
            String sql = "CREATE DATABASE JDBCExample";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }}



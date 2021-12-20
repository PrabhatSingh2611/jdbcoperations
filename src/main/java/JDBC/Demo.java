package JDBC;

import java.sql.*;
import org.postgresql.util.PSQLException;



//executing simple query of university database
public class Demo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String query1="Select * from student";
        String query2="Select * from subject";
        String query3="Select * from groups";
        String query4="Select * from department";

        Class.forName("org.postgresql.Driver");
        Connection con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/University","postgres","postgres");
        Statement st = con.createStatement();
        ResultSet rs=st.executeQuery(query1);

        //for student table
        while(rs.next()){
            //System.out.println("Data of Student Table");
            //System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getBoolean(5)+" "+rs.getString(6));

            //System.out.println("Data of Subject Table");
            //System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));

            //System.out.println("Data of Groups Table");
            //System.out.println(rs.getInt(1)+" "+rs.getString(2));

            //System.out.println("Data of Department Table");
            //System.out.println(rs.getInt(1)+" "+rs.getString(2));

        }
        rs.close();
        st.close();
        con.close();

}
}

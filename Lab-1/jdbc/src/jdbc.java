import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class jdbc{


    static final String DB_URL= "jdbc:mysql://localhost:3306/student";
    static final String USERNAME= "root";
    static final String PASSCODE= "3311";



  public static void main(String [] args){
    try(Connection connection= DriverManager.getConnection(DB_URL, USERNAME, PASSCODE);
    Statement statement= connection.createStatement()){
        System.out.println("Database connected");


        String student= "SELECT studentName FROM STUDENT";
        ResultSet response= statement.executeQuery(student);

        while (response.next()){
            String studentName= response.getString("studentName");
            System.out.println(studentName);

;            
        }



    }
    catch(SQLException e){
        e.printStackTrace();
    }
  }

}















import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class JDBCdemo{


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

        String createTableSQL = "CREATE TABLE teachers ("
        + "id INT AUTO_INCREMENT PRIMARY KEY,"
        + "first_name VARCHAR(255),"
        + "last_name VARCHAR(255),"
        + "school VARCHAR(255),"
        + "hire_date DATE,"
        + "salary DECIMAL(10, 2))";
statement.executeUpdate(createTableSQL);
System.out.println("Table 'teachers' created successfully");

// Closing the connection
connection.close();



    }
    catch(SQLException e){
        e.printStackTrace();
    }
  }

}















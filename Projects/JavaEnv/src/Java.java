import java.sql.*;

public class Java {
    public static void main(String[] args) throws SQLException {
        // SQL AUTH
        String url = "jdbc:mysql://192.168.1.25:3306/employees";
        String user = "admin";
        String password = "password";
        // SQL CONNECT
        Connection connection = DriverManager.getConnection(url,user,password);

        if(connection != null) {
            System.out.println("Connected to Database");
        }

        //Fetching Data
        Statement statement = connection.createStatement(); // New Connection

        String sql = "select student_id, student_name from student";

        ResultSet resultset = statement.executeQuery(sql);

        while(resultset.next()){
            System.out.println("Student ID "+ resultset.getInt("student_id") + "\t");
            System.out.println("Student Name "+resultset.getString("student_name")+ "\t");
        }
        connection.close();
    }
}
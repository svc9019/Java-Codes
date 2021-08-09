import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBC {

        public static void main(String[] args) throws SQLException, ClassNotFoundException {

            /**
             * Database credentials
             */
            String url = "jdbc:mysql://upgradpractice.cg1lti9azghj.us-east-1.rds.amazonaws.com/practicedb";
            String user = "admin";
            String password = "Welcome123";
            Class.forName("com.mysql.jdbc.Driver");
            /**
             * Creating a connection
             */
            Connection connection = DriverManager.getConnection(url, user, password);

            /**
             * Checking if the connection is not null
             */
            if (connection != null) {
                System.out.println("Connected to the database");
            }

            System.out.println("######  Reading the data from RDS #######");

            Statement statement = connection.createStatement();

            /** query to find the total number of districts **/

            String sql1 = "select count(*) as count from districts";

            ResultSet resultSet = statement.executeQuery(sql1);

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("count"));
                System.out.println();
            }

            /** Query to find the total number of districts in each state and arrange in an increasing order of the count.*/
            String sql2 = "select count(*) as count, state_id from districts group by state_id order by count;";

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("count"));
                System.out.println(resultSet.getString("state_id"));
                System.out.println();
            }

            /**
             * closing the statement
             */
            statement.close();

            /**
             * Dynamically supplying arguments - PreparedStatement
             */

            System.out.println("#####  Dynamically supplying arguments - PreparedStatement  #####");

            String prepareSQL = "select id, name, gender, aadhar_id, is_nri from citizens where name=? and gender=?";

            /**List NRIs with the mother tongue as ‘Hindi’.*/

            String prepareSQL1= "select id, name from citizens where is_nri=? and mother_tongue=?";

            PreparedStatement preparedStatement = connection.prepareStatement(prepareSQL);

            preparedStatement.setString(1, "True");
            preparedStatement.setString(2, "Hindi");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.print("Id is : " + resultSet.getInt("id") + "\t");
                System.out.print("Name is : " + resultSet.getString("name") + "\t");
                System.out.println();
            }

            /**Find the number of NRI females and males.*/
            String prepareSQL2 = "select count(*) from citizens where is_nri=? and gender=?";
            preparedStatement.setString(1, "True");
            preparedStatement.setString(2, "Female");

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("The number of Female NRIs are :" + resultSet.getInt("count"));
                System.out.println();
            }

            preparedStatement.setString(1, "True");
            preparedStatement.setString(2, "Male");

            while (resultSet.next()) {
                System.out.println("The number of Male NRIs are :" + resultSet.getInt("count"));
                System.out.println();
            }

            preparedStatement.close();

            /**
             * Getting the metadata about the result set
             */

            System.out.println("#####  Getting the metadata about the result set  #####");

            Statement stmt = connection.createStatement();

            String sqlString = "select id, name, gender, aadhar_id, is_nri from citizens limit 5";

            resultSet = stmt.executeQuery(sqlString);

            ResultSetMetaData resultSetMetaData = stmt.executeQuery(sqlString).getMetaData();

            System.out.println("Total columns: " + resultSetMetaData.getColumnCount());
            System.out.println("Column Name of 1st column: " + resultSetMetaData.getColumnName(1));
            System.out.println("Column Type Name of 1st column: " + resultSetMetaData.getColumnTypeName(1));

            /**
             * Closing statements
             */
            stmt.close();

            /**
             * Closing the opened connection
             */
            connection.close();
        }
}


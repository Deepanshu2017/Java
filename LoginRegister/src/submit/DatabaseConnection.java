package submit;
import java.sql.*;
/**
 * Created by deepanshu on 1/1/16.
 */
public class DatabaseConnection {

    private Connection connection;
    private Statement statement;
    public ResultSet resultSet;

    public DatabaseConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "password");
            statement = connection.createStatement();
            statement.execute("CREATE TABLE if NOT EXISTS details(first_name VARCHAR(50), " +
                    "last_name VARCHAR(50), " +
                    "email VARCHAR(50)," +
                    "password VARCHAR(50)" +
                    ")");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int setData(String query) {
        int count = 0;
        try {
            count = statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public ResultSet getData(String query) {
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

}

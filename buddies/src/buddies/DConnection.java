package buddies;
import java.sql.*;

public class DConnection {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public DConnection() {
        setData("create table if not exists users(id int primary key auto_increment, " +
                "email varchar(255) unique key not null, " +
                "password varchar(255), " +
                "mobile varchar(15) unique key not null)");
        close();
        setData("create table if not exists adminusers(id int primary key auto_increment, " +
                "email varchar(255) unique key not null, " +
                "password varchar(255), " +
                "mobile varchar(15) unique key not null)");
        close();
        setData("create table if not exists usersprofile(id int, " +
                "fname varchar(255), " +
                "lname varchar(255), " +
                "dob date, " +
                "gender enum('male', 'female'),  " +
                "foreign key(id) references users(id))");
        close();
        setData("create table if not exists post(postid int primary key auto_increment, userid int, message text, likes int, imagename varchar(20))");
        close();
    }

    private void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/buddies", "root", "Deep@deep1234");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int setData(String qry) { //insert,delete,update
        int count = 0;
        try {
            getConnection();
            statement = connection.createStatement();
            count = statement.executeUpdate(qry);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public ResultSet getData(String qry) { //select
        try {
            getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(qry);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void close() {
        try {
            statement.close();
            connection.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
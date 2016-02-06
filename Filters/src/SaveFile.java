import java.io.*;
import java.sql.*;

public class SaveFile {
    public static void myMain(String filename) {
        try {
            System.out.println("MyMain called\n" + filename);
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/school", "root", "password");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into emp values(?, ?)");
            preparedStatement.setInt(1, 1);
            File file = new File("/home/deepanshu/Desktop/" + filename);
            if(file.length() > 50 * 1024) {
                System.out.println("Cannot upload");
                return;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            preparedStatement.setBinaryStream(2, fileInputStream, (int)(file.length()));
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            System.out.println("Inserted successfully " + preparedStatement.getUpdateCount());
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/school", "root", "password");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from emp");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()) {
                InputStream inputStream = resultSet.getBinaryStream(2);
                FileOutputStream fileOutputStream = new FileOutputStream("/home/deepanshu/Desktop/img.gif");
                int i;
                while((i = inputStream.read()) != -1) {
                    fileOutputStream.write(i);
                }
                inputStream.close();
                fileOutputStream.close();
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class create {
    private static final String URL = "jdbc:mysql://localhost:3306/zoo";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void insertEmployeeData(Scanner scanNEW) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO anm (id, nama) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                System.out.println("----CREATE NEW ANIMAL DATA----");

                System.out.print("Input The Animal ID      :");
                String id = scanNEW.next();
                preparedStatement.setString(1, id);

                System.out.print("Input The Animal Name    :");
                String usernameValue = scanNEW.next();        
                preparedStatement.setString(2, usernameValue);
               
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Success!!");
                } else {
                    System.out.println("Unsuccess");
                }

                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
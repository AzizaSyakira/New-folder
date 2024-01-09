import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class updt {
    // Driver
    private static final String URL = "jdbc:mysql://localhost:3306/zoo";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void updateEmployeeCredentials(Scanner scanner) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "UPDATE anm SET nama = ? WHERE id = ? ";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                System.out.println("----UPDATE THE ANIMAL DATA----");
                System.out.print("Animal ID       :");
                String id = scanner.next();
                System.out.print("Animal Name     :");
                String nama = scanner.next();

                
                preparedStatement.setString(1, nama); 
                preparedStatement.setString(3, id);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Sukses!");
                } else {
                    System.out.println("Data not found!");
                }
            }
        } catch (SQLException e) {
        }
    }
}
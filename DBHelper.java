import java.sql.*;

public class DBHelper {

    private String k_adi = "root";
    private String k_sifre = "";
    private String url = "jdbc:mysql://localhost/world";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,k_adi,k_sifre);
    }

    public void SqlError(SQLException exception) throws SQLException {
        try {
            System.out.println("Hata: " + exception.getMessage());
            System.out.println("Hata Code: " + exception.getErrorCode());

        } finally {

        }
    }
}

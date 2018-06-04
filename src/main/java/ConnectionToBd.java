import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToBd {
    private final String URL = "jdbc:postgresql://localhost:5432/Dao";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "postgres";
    private Connection connection = null;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public Connection myCreateConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение с БД Установлено!");
                System.out.println("-----------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Неудалось загрузить класс драйвера");
        }
        return connection;
    }

}


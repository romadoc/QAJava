import buisneslayer.Dispatcher;
import models.CarShop;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseTest {
    public final String dbDir = System.getProperty("user.dir");
    final String connectionUrl = "jdbc:sqlite:" + dbDir + "./datasource/shopDB.db";
    public Connection connection;
    Statement statement;
    Dispatcher dispatcher = new Dispatcher("sql");
    CarShop carShop = dispatcher.getCarShop();

    @BeforeEach
    public void openConnection() throws SQLException {
        this.connection = DriverManager.getConnection(connectionUrl);
        this.statement = this.connection.createStatement();
    }

    @AfterEach
    public void closeConnection() throws SQLException {
        if(connection != null) connection.close();
    }
}

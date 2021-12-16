package connectors.sqlconnectors;

import org.apache.commons.dbutils.QueryRunner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BaseDbConnector {

    public QueryRunner queryRunner = new QueryRunner();
    public final String dbDir = System.getProperty("user.dir");
    final String connectionUrl = "jdbc:sqlite:" + dbDir + "/datasource/shopDB.db";
    public Connection connection;

    {
        try {
            connection = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

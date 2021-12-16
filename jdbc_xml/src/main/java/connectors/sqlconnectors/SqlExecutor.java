package connectors.sqlconnectors;

import java.sql.SQLException;
import java.sql.Statement;

public class SqlExecutor extends BaseDbConnector {
    String sqlQueryString;

    public SqlExecutor(String sqlQueryString) {
        this.sqlQueryString = sqlQueryString;
    }
    public void executeQuery() {

        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlQueryString);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

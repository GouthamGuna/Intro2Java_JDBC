package in.dev.gmsk.repository;

import in.dev.gmsk.model.JDBCModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    public static Connection getJDBCConnection(JDBCModel model) throws SQLException {
        return DriverManager.getConnection( model.getURI(), model.getDbUserName(), model.getDbPassword() );
    }
}

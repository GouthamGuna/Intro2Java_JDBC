package in.dev.gmsk.repository;

import in.dev.gmsk.model.JDBCModel;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class JDBCConnectionTest {

    @Test
    void getJDBCConnection() throws SQLException {

        Connection jdbcConnection = JDBCConnection.getJDBCConnection( JDBCModel.getJDBCModelInstance() );
        assertNotNull( jdbcConnection );

        assertTrue( jdbcConnection.isValid( 0 ) );

        jdbcConnection.close();
    }
}
package in.dev.gmsk.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ResourceBundle;

@Data
@Setter
@Getter
public class JDBCModel {

    private static JDBCModel JDBC_MODEL;
    private static final ResourceBundle RESOURCE_BUNDLE;

    private String driver;
    private String protocol;
    private String host;
    private String port;
    private String dbDataName;
    private String dbUserName;
    private String dbPassword;
    private String URI;

    private JDBCModel() {
    }

    static {
        JDBC_MODEL = new JDBCModel();
        RESOURCE_BUNDLE = ResourceBundle.getBundle( "application" );

        JDBC_MODEL.setDriver( RESOURCE_BUNDLE.getString( "SqlDriver" ) );
        JDBC_MODEL.setProtocol( RESOURCE_BUNDLE.getString( "protocol" ) );
        JDBC_MODEL.setHost( RESOURCE_BUNDLE.getString( "host" ) );
        JDBC_MODEL.setPort( RESOURCE_BUNDLE.getString( "port" ) );
        JDBC_MODEL.setDbDataName( RESOURCE_BUNDLE.getString( "dbDataName" ) );
        JDBC_MODEL.setDbUserName( RESOURCE_BUNDLE.getString( "dbUserName" ) );
        JDBC_MODEL.setDbPassword( RESOURCE_BUNDLE.getString( "dbPassword" ) );

        JDBC_MODEL.setURI( "%s://%s:%s/%s".formatted( JDBC_MODEL.getProtocol(), JDBC_MODEL.getHost(), JDBC_MODEL.getPort(), JDBC_MODEL.getDbDataName() ) );
    }

    public static synchronized JDBCModel getJDBCModelInstance() {
        if (JDBC_MODEL == null) {
            JDBC_MODEL = new JDBCModel();
        }
        return JDBC_MODEL;
    }
}

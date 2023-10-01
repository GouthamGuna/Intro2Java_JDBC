package in.dev.gmsk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ContactDaoImpl implements ContactDao{

    private static final String SELECT_BY_ID = "SELECT * FROM contacts WHERE id = ?";
    private static final String SELECT_BY_NAME = "SELECT * FROM contacts WHERE name = ?";
    private static final String UPDATE = "UPDATE contacts SET name=?, phone=?, email=? WHERE id = ?";
    private static final String INSERT = "INSERT INTO contacts (name, phone, email) VALUES (?, ?, ?)";
    private static final String DELETE = "DELETE FROM contacts WHERE id = ?";
    private final String url;
    private final String user;
    private final String password;

    public ContactDaoImpl(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);

    }

    @Override
    public Contact getContactByName(String name) {
        return null;
    }
}

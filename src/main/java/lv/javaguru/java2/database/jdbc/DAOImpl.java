package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Viktor on 01/07/2014.
 */

public class DAOImpl implements DAO {

    private static final String DB_CONFIG_FILE = "prod_monaco_db.properties";

    private String dbUrl = null;
    private String userName = null;
    private String password = null;

    public DAOImpl() {
        registerJDBCDriver();
        initDatabaseConnectionProperties();
    }

    private void registerJDBCDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Exception while registering JDBC driver!");
            e.printStackTrace();
        }
    }

    private void initDatabaseConnectionProperties() {
        Properties properties = new Properties();
        try {
            properties.load(DAOImpl.class.getClassLoader().getResourceAsStream(DB_CONFIG_FILE));

            dbUrl = properties.getProperty("dbUrl");
            userName = properties.getProperty("userName");
            password = properties.getProperty("password");
        } catch (IOException e){
            System.out.println("Exception while reading JDBC configuration from file = " + DB_CONFIG_FILE);
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws DBException {
        try{
            return DriverManager.getConnection(dbUrl, userName, password);
        } catch (SQLException e) {
            System.out.println("Exception while getting connection to database");
            e.printStackTrace();
            throw new DBException(e);
        }
    }

    public void closeConnection(Connection connection) throws DBException {
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Exception while closing connection to database");
            e.printStackTrace();
            throw new DBException(e);
        }
    }

}

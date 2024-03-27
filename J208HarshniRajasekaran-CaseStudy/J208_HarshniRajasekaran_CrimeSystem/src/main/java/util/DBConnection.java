/**
 * The DBConnection class provides utility methods for establishing a database connection.
 * It utilizes JDBC to connect to a MySQL database server.
 * 
 * This class ensures that only one database connection is created throughout the application's lifecycle.
 * 
 * The database connection parameters (hostname, database name, username, password, and port) are defined as constants.
 * 
 * @author Harshni
 * 
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    // Database connection parameters
    private static final String HOSTNAME = "localhost";
    private static final String DB_NAME = "crimecase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Harsh@1109";
    private static final String PORT = "3306"; 

    /**
     * Returns a database connection instance.
     * If the connection is not already established, it creates a new connection.
     * 
     * @return The database Connection object
     */
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                String connectionString = getConnectionString();
                // Establish connection using DriverManager
                connection = DriverManager.getConnection(connectionString, USERNAME, PASSWORD);
                System.out.print("Connection done");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * Constructs the JDBC connection string based on the defined connection parameters.
     * 
     * @return The JDBC connection string
     */
    private static String getConnectionString() {
        return "jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DB_NAME;
    }
}

package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {


    private static Connection conn = null;

    public static Connection getConn() throws SQLException {
        if (conn == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            }
            catch (SQLException e) {
                throw new dbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConn() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new dbException(e.getMessage());
            }
        }

        else {
            System.out.println("A conexão não foi iniciada");
        }
    }


    private static Properties loadProperties() {
        try(FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
                System.out.println("Statement finalizado");
            } catch (SQLException e) {
                throw new dbException(e.getMessage());
            }
        }
    }
    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
                System.out.println("Result finalizado");
            } catch (SQLException e) {
                throw new dbException(e.getMessage());
            }
        }
    }

}

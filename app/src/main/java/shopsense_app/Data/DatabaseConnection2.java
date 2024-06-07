package shopsense_app.Data;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseConnection2 {
	protected String query;
	private static final String URL = "jdbc:sqlite:barang.db";
	protected static Connection connection;
	protected static PreparedStatement prepareStatement;
	protected static ResultSet resultSet;

	public static Connection connect() {
    	Connection conn = null;
    	try {
        	conn = DriverManager.getConnection(URL);
        	System.out.println("Koneksi berhasil ke SQLite.");
    	} catch (SQLException e) {
        	System.out.println(e.getMessage());
    	}
    	return conn;
	}
}


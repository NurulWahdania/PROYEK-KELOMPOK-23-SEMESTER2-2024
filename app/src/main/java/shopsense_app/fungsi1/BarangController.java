package shopsense_app.fungsi1;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import shopsense_app.fungsiMenu.Barang;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shopsense_app.Data.DatabaseConnection2;
public class BarangController{
	public void createTable() {
    	String sql = "CREATE TABLE IF NOT EXISTS barang ("
               	+ " nama TEXT PRIMARY KEY,"
               	+ " harga TEXT NOT NULL,"
               	+ " stok TEXT NOT NULL"
               	+ ");";
	
    	try (Connection conn = DatabaseConnection2.connect();
         	Statement stmt = conn.createStatement()) {
        	stmt.execute(sql);
        	System.out.println("Tabel berhasil dibuat.");
    	} catch (SQLException e) {
        	System.out.println(e.getMessage());
    	}
	}
	public void insert(String nama, String harga, String stok) {
		createTable();
    	String sql = "INSERT INTO barang(nama, harga, stok) VALUES(?, ?, ?)";
    	try (Connection conn = DatabaseConnection2.connect();
         	PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setString(1, harga);
			pstmt.setString(2, stok);
        	pstmt.setString(3, nama);
        	pstmt.executeUpdate();
        	System.out.println("Data berhasil ditambahkan.");
    	} catch (SQLException e) {
        	System.out.println(e.getMessage());
    	}
	}
	public ObservableList<Barang> selectAll() {
    	String sql = "SELECT nama, harga, stok FROM barang";
    	ObservableList<Barang> data = FXCollections.observableArrayList();
    	try (Connection conn = DatabaseConnection2.connect();
         	Statement stmt = conn.createStatement();
         	ResultSet rs = stmt.executeQuery(sql)) {
        	while (rs.next()) {
            	Barang barang = new Barang(
                    	rs.getString("nama"),
                    	rs.getString("harga"),
                    	rs.getString("stok")
            	);
            	data.add(barang);
        	}
    	} catch (SQLException e) {
        	System.out.println(e.getMessage());
    	}
    	return data;
	}
	public void update(String nama, String harga, String stok) {
    	String sql = "UPDATE barang SET harga = ?, stok = ? WHERE nama = ?";
    	try (Connection conn = DatabaseConnection2.connect();
         	PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setString(1, nama);
        	pstmt.setString(1, harga);
        	pstmt.setString(2, stok);
        	pstmt.setString(3, nama);
        	pstmt.executeUpdate();
        	System.out.println("Data berhasil diperbarui.");
    	} catch (SQLException e) {
        	System.out.println(e.getMessage());
    	}
	}
	public void delete(String nama) {
    	String sql = "DELETE FROM barang WHERE nama = ?";
    	try (Connection conn = DatabaseConnection2.connect();
         	PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setString(1, nama);
        	pstmt.executeUpdate();
        	System.out.println("Data berhasil dihapus.");
    	} catch (SQLException e) {
        	System.out.println(e.getMessage());
    	}
	}	


		// Metode lainnya...

	public void updateStok(String nama, int newStok) {
			// Logika untuk memperbarui stok barang di database
		String query = "UPDATE barang SET stok = ? WHERE nama = ?";
		try (Connection conn = DatabaseConnection2.connect();
			PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, newStok);
			pstmt.setString(2, nama);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}


}
package shopsense_app.fungsiMenu;


import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shopsense_app.Data.DatabaseConnection2;
import shopsense_app.scene.Karyawan;

public class KaryawanConnection {
    public void createTable() {
    	String sql = "CREATE TABLE IF NOT EXISTS barang ("
               	+ " nama TEXT NOT NULL,"
               	+ " id karyawan  PRIMARY KEY INTEGER NOT NULL UNIQUE"
               	+ " posisi TEXT NOT NULL"
                + " tanggal masuk TEXT NOT NULL"
               	+ ");";

    	try (Connection conn = DatabaseConnection2.connect();
         	Statement stmt = conn.createStatement()) {
        	stmt.execute(sql);
        	System.out.println("Tabel berhasil dibuat.");
    	} catch (SQLException e) {
        	System.out.println(e.getMessage());
    	}
    }

    public void insert(String nama, int id_karyawan, String posisi, String tanggal_masuk) {
		createTable();
    	String sql = "INSERT INTO karyawan(nama, 'id karyawan', posisi, 'tanggal masuk') VALUES(?, ?, ?, ?)";
    	try (Connection conn = DatabaseConnection2.connect();
         	PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setString(1, nama);
			pstmt.setInt(2, id_karyawan);
        	pstmt.setString(3, posisi);
            pstmt.setString(4, tanggal_masuk);
        	pstmt.executeUpdate();
        	System.out.println("Data berhasil ditambahkan.");
    	} catch (SQLException e) {
        	System.out.println(e.getMessage());
    	}
    }

    public ObservableList<Karyawan> selectAll() {
    	String sql = "SELECT nama, id karyawan, posisi, tanggal masuk FROM karyawan";
    	ObservableList<Karyawan> data = FXCollections.observableArrayList();

    	try (Connection conn = DatabaseConnection2.connect();
         	Statement stmt = conn.createStatement();
         	ResultSet rs = stmt.executeQuery(sql)) {

        	while (rs.next()) {
            	    Karyawan karyawan = new Karyawan(
                    	rs.getString("nama"),
                    	rs.getInt("id karyawan"),
                    	rs.getString("posisi"),
                        rs.getString("tanggal masuk")
            	);
            	data.add(karyawan);
        	}
    	} catch (SQLException e) {
        	System.out.println(e.getMessage());
    	}
    	return data;
	}


}
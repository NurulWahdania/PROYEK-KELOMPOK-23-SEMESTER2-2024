package shopsense_app.Data;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shopsense_app.scene.Barang;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


// public class TranksaksiControler {
//     public void Creattable() {
//         String sql= "CREAT TABLE IF NOT EXISTS tranksaksi ("
//             + "No INTEGER PRIMARY KEY,"
//             + "Jumlah Produk TEXT NOT NULL,"
//             + "Nama Produk TEXT NOT NULL,"
//             + ");";

//         try (Connection conn = DatabaseConnection.connect();
//             Statement stmt = conn.createStatement()) {
//             stmt.execute(sql);
//             System.out.println("Tabel berhasil dibuat.");
//             }
//     	} catch (SQLException e) {
//         	System.out.println(e.getMessage() );
//     	}


// }

package shopsense_app.Data;
// package shopsense_app.fungsi1;


// import java.sql.Statement;
// import java.sql.ResultSet;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;
// import java.sql.PreparedStatement;
// import shopsense_app.fungsiMenu.Barang;
// import shopsense_app.fungsiMenu.Karyawan;
// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;
// import javafx.scene.control.TableView;
// import shopsense_app.Data.DatabaseConnection2;

// public class KaryawanController {
//     public void createTable() {
//     	String sql = "CREATE TABLE IF NOT EXISTS karyawan ("
//                	+ " nama TEXT NOT NULL,"
//                	+ " id_karyaean TEXT PRIMARY KEY,"
//                	+ " posisi TEXT NOT NULL"
//                 + "tanggal_masuk TEXT NOT NULL"
//                	+ ");";

//         try (Connection conn = DatabaseConnection2.connect();
//             Statement stmt = conn.createStatement()) {
//             stmt.execute(sql);
//             System.out.println("Tabel berhasil dibuat.");
//             } catch (SQLException e) {
//                 System.out.println(e.getMessage());
//             } 
//     }

//     public void insert(String nama, int id_karyaean, String posisi, String tanggal_masuk) {
// 		createTable();
//     	String sql = "INSERT INTO karyawan(nama, id_karyawan, posisi, tanggal_masuk) VALUES(?, ?, ?, ?)";
//     	try (Connection conn = DatabaseConnection2.connect();
//          	PreparedStatement pstmt = conn.prepareStatement(sql)) {
//         	pstmt.setString(1, nama);
// 			pstmt.setInt(2, id_karyaean);
//         	pstmt.setString(3, posisi);
//             pstmt.setString(4, tanggal_masuk);
//         	pstmt.executeUpdate();
//         	System.out.println("Data berhasil ditambahkan.");
//     	} catch (SQLException e) {
//         	System.out.println(e.getMessage());
//     	}
// 	}
// }
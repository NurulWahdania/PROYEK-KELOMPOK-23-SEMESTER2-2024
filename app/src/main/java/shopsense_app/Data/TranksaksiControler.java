package shopsense_app.Data;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shopsense_app.fungsiMenu.TransaksiClass;

public class TranksaksiControler {
    public boolean addHasil(int hasil, String waktu, String nama) {
        String query = "INSERT INTO penghasilan(hasil,waktu, nama_karyawan) VALUES (?, ?,?)";
        try (Connection conn = DatabaseConnection2.connect()) {
            PreparedStatement prepareStatement = conn.prepareStatement(query);
            prepareStatement.setInt(1, hasil);
            prepareStatement.setString(2, waktu);
            prepareStatement.setString(3, nama);
            prepareStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public ObservableList<TransaksiClass> selectAll() {
        String sql = "SELECT hasil, nama_karyawan, waktu FROM penghasilan";
        ObservableList<TransaksiClass> data = FXCollections.observableArrayList();
        try (Connection conn = DatabaseConnection2.connect();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TransaksiClass tf = new TransaksiClass(
                        rs.getInt("hasil"),
                        rs.getString("waktu"),
                        rs.getString("nama_karyawan"));
                data.add(tf);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }


    }


package shopsense_app.fungsiMenu;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import shopsense_app.scene.LaporanToko;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shopsense_app.Data.DatabaseConnection2;

public class PemasukanController {
    	public ObservableList<LaporanToko> selectAll() {
    	String sql = "SELECT hasil FROM penghasilan";
    	ObservableList<LaporanToko> hasil = FXCollections.observableArrayList();
    	try (Connection conn = DatabaseConnection2.connect();
         	Statement stmt = conn.createStatement();
         	ResultSet rs = stmt.executeQuery(sql)) {
        	while (rs.next()) {
            	LaporanToko money = new LaporanToko(
                    	rs.getString("hasil")
            	);
            	hasil.add(money);
        	}
    	} catch (SQLException e) {
        	System.out.println(e.getMessage());
    	}
    	return hasil;
	}
}

package shopsense_app.fungsiMenu;

import shopsense_app.scene.Barang;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataProvider {
    public ObservableList<Barang> data;

    public DataProvider() {
        data = FXCollections.observableArrayList();
    }

    public ObservableList<Barang> getData() {
        return data;
    }

    public void addBarang(Barang barang) {
        data.add(barang);
    }
}

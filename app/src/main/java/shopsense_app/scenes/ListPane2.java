package shopsense_app.scenes;

import shopsense_app.fungsi1.BarangController;
import shopsense_app.fungsiMenu.Barang;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import shopsense_app.fungsiMenu.Barang;
public class ListPane2 {



    TableView<shopsense_app.fungsiMenu.Barang> tableView;
    BarangController barangController = new BarangController();

    public VBox getListPane() {

        tableView = new TableView<>();
        TableColumn<Barang, String> namaColum = new TableColumn<>("NAMA BARANG");
        namaColum.setCellValueFactory(new PropertyValueFactory<>("nama"));
        TableColumn<Barang, String> hargaColum = new TableColumn<>("HARGA BARANG");
        hargaColum.setCellValueFactory(new PropertyValueFactory<>("harga"));
        TableColumn<Barang, String> stokColum = new TableColumn<>("STOK BARANG");
        stokColum.setCellValueFactory(new PropertyValueFactory<>("stok"));

        tableView.getColumns().add(namaColum);
        tableView.getColumns().add(hargaColum);
        tableView.getColumns().add(stokColum);
        tableView.setMinWidth(400);

        ScrollPane scrollPane = new ScrollPane(tableView);
        scrollPane.setMaxHeight(200);
        scrollPane.setMinWidth(400);
 
        VBox vbox = new VBox(scrollPane);
        vbox.setMaxHeight(200);
        vbox.setMaxWidth(400);
        vbox.setMinHeight(200);
        vbox.setMinWidth(400);
        vbox.setAlignment(Pos.CENTER_LEFT);
        // vbox.setAlignment(Pos.CENTER);
        

        loadData();
        return vbox;
    }

     public void loadData() {
        ObservableList<Barang> barang = barangController.selectAll();
        tableView.setItems(barang);
    }

}


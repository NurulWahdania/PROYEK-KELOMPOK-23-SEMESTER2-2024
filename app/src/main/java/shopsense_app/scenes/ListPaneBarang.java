package shopsense_app.scenes;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableView;
import javafx.scene.control.ScrollPane;
import shopsense_app.fungsiMenu.Barang;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.collections.ObservableList;
import shopsense_app.fungsi1.BarangController;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListPaneBarang {
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
        ObservableList<Barang> data = FXCollections.observableArrayList();
        tableView.setItems(data);
        tableView.getColumns().add(namaColum);
        tableView.getColumns().add(hargaColum);
        tableView.getColumns().add(stokColum);
        tableView.setMinWidth(400);

        // ScrollPane scrollPane = new ScrollPane(tableView);
        // scrollPane.setMaxHeight(200);
        // scrollPane.setMinWidth(400);

        VBox vbox = new VBox(tableView);
        vbox.setMaxHeight(200);
        vbox.setMaxWidth(400);
        vbox.setMinHeight(200);
        vbox.setMinWidth(400);
        vbox.setAlignment(Pos.CENTER_LEFT);
        
        loadData();
        return vbox;
    }
     public void loadData() {
        ObservableList<Barang> barang = barangController.selectAll();
        System.out.println(String.valueOf(barang.size()));
        tableView.setItems(barang);
    }
}
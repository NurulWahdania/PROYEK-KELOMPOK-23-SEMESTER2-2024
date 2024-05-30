package shopsense_app.scenes;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableView;
import javafx.scene.control.ScrollPane;
import shopsense_app.fungsiMenu.BarangController;
import shopsense_app.fungsiMenu.PemasukanController;
import shopsense_app.scene.Barang;
import shopsense_app.scene.LaporanToko;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListPaneBarang {
    TableView<shopsense_app.scene.Barang> tableView;
    BarangController barangController = new BarangController();

    TableView<shopsense_app.scene.LaporanToko> tableView1;
    PemasukanController PemasukanController = new PemasukanController();

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
    
    public VBox laporanList() {
        tableView1 = new TableView<>();
        TableColumn<LaporanToko, String> namaColum = new TableColumn<>("Penghasilan");
        namaColum.setCellValueFactory(new PropertyValueFactory<>("penghasilan"));
        TableColumn<LaporanToko, String> hargaColum = new TableColumn<>("Tanggal");
        hargaColum.setCellValueFactory(new PropertyValueFactory<>("harga"));
        ObservableList<LaporanToko> data1 = FXCollections.observableArrayList();
        tableView1.setItems(data1);
        tableView1.getColumns().add(namaColum);
        tableView1.getColumns().add(hargaColum);
        tableView1.setMinWidth(400);

        VBox vbox1 = new VBox(tableView1);
        vbox1.setMaxHeight(200);
        vbox1.setMaxWidth(400);
        vbox1.setMinHeight(200);
        vbox1.setMinWidth(400);
        vbox1.setAlignment(Pos.CENTER_LEFT);
        
        loadDataPenghasilan();
        return vbox1;
    }
    public void loadDataPenghasilan() {
       ObservableList<LaporanToko> uang = PemasukanController.selectAll();
       System.out.println(String.valueOf(uang.size()));
       tableView1.setItems(uang);
   }
}
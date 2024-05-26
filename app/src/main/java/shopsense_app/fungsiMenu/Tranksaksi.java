package shopsense_app.fungsiMenu;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import shopsense_app.fungsi1.BarangController;
import shopsense_app.scenes.Menuisi;

public class Tranksaksi {
    Stage stage;

    public Tranksaksi(Stage stage) {
        this.stage = stage;
    }

    TableView<shopsense_app.fungsiMenu.Barang> tableView;
    TableView<BarangWithStock> rightTableView;
    BarangController barangController = new BarangController();
    private ObservableList<BarangWithStock> selectedItems = FXCollections.observableArrayList();
    private Label totalLabel;

    public void show() {
        // Initialize left table view
        tableView = new TableView<>();
        TableColumn<Barang, String> namaColum = new TableColumn<>("NAMA BARANG");
        namaColum.setCellValueFactory(new PropertyValueFactory<>("nama"));
        namaColum.setPrefWidth(130);
        TableColumn<Barang, String> hargaColum = new TableColumn<>("HARGA BARANG");
        hargaColum.setCellValueFactory(new PropertyValueFactory<>("harga"));
        hargaColum.setPrefWidth(120);
        TableColumn<Barang, String> stokColum = new TableColumn<>("STOK BARANG");
        stokColum.setCellValueFactory(new PropertyValueFactory<>("stok"));
        stokColum.setPrefWidth(100);
        
        tableView.getColumns().add(namaColum);
        tableView.getColumns().add(hargaColum);
        tableView.getColumns().add(stokColum);
        tableView.setMinWidth(340);
        tableView.setMinHeight(340);

        // Initialize right table view
        rightTableView = new TableView<>();
        TableColumn<BarangWithStock, String> namaColumRight = new TableColumn<>("NAMA BARANG");
        namaColumRight.setCellValueFactory(new PropertyValueFactory<>("nama"));
        namaColumRight.setPrefWidth(130);
        TableColumn<BarangWithStock, String> hargaColumRight = new TableColumn<>("HARGA BARANG");
        hargaColumRight.setCellValueFactory(new PropertyValueFactory<>("harga"));
        hargaColumRight.setPrefWidth(120);
        TableColumn<BarangWithStock, Integer> stokColumRight = new TableColumn<>("JUMLAH");
        stokColumRight.setCellValueFactory(new PropertyValueFactory<>("stock"));
        stokColumRight.setPrefWidth(100);
        
        
        rightTableView.getColumns().add(namaColumRight);
        rightTableView.getColumns().add(hargaColumRight);
        rightTableView.getColumns().add(stokColumRight);
        rightTableView.setMinWidth(340);
        rightTableView.setMaxHeight(250);

        Label label = new Label("Tranksaksi");
        label.getStyleClass().add("judul3");

        Button label2 = new Button("\t\tBarang Yang Di Beli\t\t");
        label2.getStyleClass().add("buton7");

        Button main = new Button("<\t\t\tMain Menu\t\t\t>");
        main.getStyleClass().add("buton7");

        Button add = new Button("+");
        add.getStyleClass().add("buton6");
        add.setOnAction(e -> incrementStock());

        Button less = new Button("-");
        less.getStyleClass().add("buton6");
        less.setOnAction(e -> decrementStock());

        Button hasil = new Button("HASIL");
        hasil.getStyleClass().add("buton8");
        hasil.setOnAction(e -> processTransaction());

        Button delet = new Button("DELET");
        delet.getStyleClass().add("buton8");
        delet.setOnAction(e -> deleteSelectedItem());

        Button home = new Button("Home");
        home.getStyleClass().add("home2");
        home.setOnAction(e -> {
            Menuisi menu = new Menuisi(stage);
            menu.show();
        });

        VBox home2 = new VBox(home);
        home2.setAlignment(Pos.BOTTOM_RIGHT);

        HBox buton = new HBox(10, add,delet, hasil, less);
        buton.setAlignment(Pos.CENTER);

        totalLabel = new Label("Total: 0");
        totalLabel.setMinWidth(0);
        totalLabel.getStyleClass().add("total-label");
        

        VBox totalBox = new VBox(buton, totalLabel);
        totalBox.setAlignment(Pos.CENTER);
        totalBox.setSpacing(30);

        Rectangle rectangle3 = new Rectangle(340, 35);
        rectangle3.setFill(Color.web("#D9D9D9"));
        
        HBox rec2 = new HBox(rectangle3);
        rec2.setPadding(new Insets(485,0, 0, 440));

        VBox rec = new VBox(20, label2, rightTableView, totalBox);
        rec.setPadding(new Insets(40, 0, 0, 30));
        rec.setAlignment(Pos.CENTER);

        VBox menu1 = new VBox(20, label, main, tableView);
        HBox sejajar = new HBox(menu1, rec);

        sejajar.setSpacing(30);
        VBox all = new VBox(sejajar, home2);
        Pane root = new Pane(rec2, all);
        all.setPadding(new Insets(20));
        root.getStyleClass().add("background2");
        root.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);

        // Load data into left table
        loadData();

        // Add selection listener to left table
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                addItemToRightTable(newValue);
            }
        });
    }

    public void loadData() {
        ObservableList<Barang> barang = barangController.selectAll();
        tableView.setItems(barang);
    }

    public void addItemToRightTable(Barang barang) {
        // Cek apakah barang sudah ada di daftar selectedItems
        BarangWithStock existingItem = findItemInRightTable(barang);
        if (existingItem != null) {
            existingItem.incrementStock();
        } else {
            selectedItems.add(new BarangWithStock(barang.getNama(), barang.getHarga(), barang.getStok(), 0));
        }
        rightTableView.setItems(selectedItems);
        rightTableView.refresh(); // Refresh the table view to update the displayed stock
        updateTotal();
    }

    public BarangWithStock findItemInRightTable(Barang barang) {
        for (BarangWithStock item : selectedItems) {
            if (item.getNama().equals(barang.getNama())) {
                return item;
            }
        }
        return null;
    }

    public void incrementStock() {
        BarangWithStock selectedItem = rightTableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            selectedItem.incrementStock();
            rightTableView.refresh(); // Refresh the table view to update the displayed stock
            updateTotal();
        }
    }

    public void decrementStock() {
        BarangWithStock selectedItem = rightTableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null && selectedItem.getStock() > 0) {
            selectedItem.decrementStock();
            rightTableView.refresh(); // Refresh the table view to update the displayed stock
            updateTotal();
        }
    }

    public void deleteSelectedItem() {
        BarangWithStock selectedItem = rightTableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            selectedItems.remove(selectedItem);
            rightTableView.refresh(); // Refresh the table view to remove the item from the display
            updateTotal();
        }
    }

    public void processTransaction() {
        // Mengurangi stok pada tabel kiri dan database
        for (BarangWithStock item : selectedItems) {
            Barang barang = findItemInLeftTable(item.getNama());
            if (barang != null) {
                int newStock = Integer.parseInt(barang.getStok()) - item.getStock();
                barang.setStok(String.valueOf(newStock));
                barangController.updateStok(barang.getNama(), newStock);
            }
        }
        // Kosongkan tabel kanan setelah transaksi
        selectedItems.clear();
        rightTableView.refresh();
        // Perbarui total
        updateTotal();
        // Refresh tabel kiri untuk memperbarui stok yang ditampilkan
        tableView.refresh();
    }

    public Barang findItemInLeftTable(String nama) {
        for (Barang barang : tableView.getItems()) {
            if (barang.getNama().equals(nama)) {
                return barang;
            }
        }
        return null;
    }

    public void updateTotal() {
        int total = 0;
        for (BarangWithStock item : selectedItems) {
            total += Integer.parseInt(item.getHarga()) * item.getStock();
        }
        totalLabel.setText("Total: " + total);
    }

    public static class BarangWithStock extends shopsense_app.fungsiMenu.Barang {
        private final SimpleIntegerProperty stock;

        public BarangWithStock(String nama, String harga, String stok, int initialStock) {
            super(nama, harga, stok);
            this.stock = new SimpleIntegerProperty(initialStock);
        }

        public int getStock() {
            return stock.get();
        }

        public void setStock(int stock) {
            this.stock.set(stock);
        }

        public SimpleIntegerProperty stockProperty() {
            return stock;
        }

        public void incrementStock() {
            setStock(getStock() + 1);
        }

        public void decrementStock() {
            setStock(getStock() - 1);
        }
    }
}

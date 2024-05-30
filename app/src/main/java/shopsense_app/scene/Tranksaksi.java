package shopsense_app.scene;

import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import shopsense_app.Data.DatabaseConnection2;

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
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import shopsense_app.Data.TranksaksiControler;
import shopsense_app.fungsiMenu.BarangController;
import shopsense_app.fungsiMenu.KaryawanConnection;

public class Tranksaksi {
    Stage stage;

    public Tranksaksi(Stage stage) {
        this.stage = stage;
    }

    TableView<shopsense_app.scene.Barang> tableView;
    TableView<Stokbarang> rightTableView;
    BarangController barangController = new BarangController();
    private ObservableList<Stokbarang> selectedItems = FXCollections.observableArrayList();
    private Label totalLabel;
    private int hasilBelanja;
    private TextField diskon;
    private Button hasil;
    private Label salah;

    public void show() {

        TextField idKaryawan = new TextField();
        idKaryawan.setPromptText("Masukan Id");
        idKaryawan.setOnAction(e -> {

        });

        idKaryawan.getStyleClass().add("text2");

        // TextField namaKaryawan = new TextField();
        // namaKaryawan.setPromptText("Masukan Nama");
        // namaKaryawan.getStyleClass().add("text2");

        HBox atas = new HBox(10, idKaryawan);

        // Label nmToko = new Label(Home.namaToko);
        // nmToko.getStyleClass().add("tokok");
        Line line = new Line();
        line.setStartY(0);
        line.setStartX(20);
        line.setEndY(20);
        line.setEndX(20);
        line.setStrokeWidth(2);
        line.setStroke(Color.BLACK);
        HBox all = new HBox(10,atas ,line);
        all.setPadding(new Insets(30,0,0,790));
    
        tableView = new TableView<>();
        TableColumn<Barang, String> namaColum = new TableColumn<>("NAMA BARANG");
        namaColum.setCellValueFactory(new PropertyValueFactory<>("nama"));
        namaColum.setPrefWidth(180);
        TableColumn<Barang, String> hargaColum = new TableColumn<>("HARGA BARANG");
        hargaColum.setCellValueFactory(new PropertyValueFactory<>("harga"));
        hargaColum.setPrefWidth(170);
    
        tableView.getColumns().add(namaColum);
        tableView.getColumns().add(hargaColum);
        tableView.setMinWidth(340);
        tableView.setMinHeight(340);
    
        rightTableView = new TableView<>();
        TableColumn<Stokbarang, String> namaColumRight = new TableColumn<>("NAMA BARANG");
        namaColumRight.setCellValueFactory(new PropertyValueFactory<>("nama"));
        namaColumRight.setPrefWidth(130);
        TableColumn<Stokbarang, String> hargaColumRight = new TableColumn<>("HARGA BARANG");
        hargaColumRight.setCellValueFactory(new PropertyValueFactory<>("harga"));
        hargaColumRight.setPrefWidth(120);
        TableColumn<Stokbarang, Integer> stokColumRight = new TableColumn<>("JUMLAH");
        stokColumRight.setCellValueFactory(new PropertyValueFactory<>("stock"));
        stokColumRight.setPrefWidth(100);
    
        rightTableView.getColumns().add(namaColumRight);
        rightTableView.getColumns().add(hargaColumRight);
        rightTableView.getColumns().add(stokColumRight);
        rightTableView.setMinWidth(340);
        rightTableView.setMaxHeight(250);

    
        Label label = new Label("Tranksaksi");
        label.getStyleClass().add("judul5");
    
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
    
        hasil = new Button("HASIL");
        hasil.getStyleClass().add("buton8");
        hasil.setOnAction(e -> {
            String nama_karyawan = cekNamaKaryawan(idKaryawan.getText());
            TranksaksiControler tr = new TranksaksiControler();
            tr.addHasil(hasilBelanja, waktu(), nama_karyawan);
            processTransaction();}
        );
    
        Button delet = new Button("CLEAR");
        delet.getStyleClass().add("buton8");
        delet.setOnAction(e -> deleteSelectedItem());
    
        diskon = new TextField();
        diskon.setPromptText("Diskon %");
        diskon.getStyleClass().add("diskon");
        diskon.setPadding(new Insets(-20,0,0,0));
        diskon.setMaxSize(100, 30);
        diskon.setAlignment(Pos.CENTER);
        TextFormatter<String> textFormatter1 = new TextFormatter<>(change -> {
                    String newText = change.getControlNewText();
                    if (newText.matches("\\d*")) {
                        return change;
                    }
                    return null;
                });
        diskon.setTextFormatter(textFormatter1);
        HBox buton = new HBox(10, add,delet, hasil, less);
        buton.setAlignment(Pos.CENTER);
    
        totalLabel = new Label("Total: 0");
        totalLabel.setMinWidth(0);
        totalLabel.getStyleClass().add("total-label");
    
        VBox totalBox = new VBox(buton, diskon, totalLabel);
        totalBox.setAlignment(Pos.CENTER);
        totalBox.setSpacing(30);
    
        Rectangle rectangle3 = new Rectangle(340, 35);
        rectangle3.setFill(Color.web("#D9D9D9"));
    
        HBox rec2 = new HBox(rectangle3);
        rec2.setPadding(new Insets(520,0, 0, 800));
    
        VBox spasi = new VBox(20, label2, rightTableView);
        VBox recc = new VBox(10, spasi, totalBox);
        recc.setPadding(new Insets(55, 0, 0, 100));
        recc.setAlignment(Pos.CENTER);
        recc.setSpacing(10);
    
        VBox men = new VBox(20, label, main, tableView);
        HBox sejajar = new HBox(men, recc);
        sejajar.setSpacing(30);
        sejajar.setPadding(new Insets(40,0,0,0));

        Label menu1 = new Label("MENU");
        menu1.getStyleClass().add("judul");
        menu1.setPadding(new Insets(0,0,0,25));

        Button keuangan = new Button("Laporan Toko");
        keuangan.getStyleClass().add("buton2");
        keuangan.setOnAction(e -> {
            LaporanToko uang = new LaporanToko(stage);
            uang.show();
        });
        Button barang = new Button("Barang");
        barang.getStyleClass().add("buton2");
        barang.setOnAction(e -> {
            Barang brg = new Barang(stage);
            brg.show();
        });
        Button karyawan = new Button("Karyawan");
        karyawan.getStyleClass().add("buton2");
        karyawan.setOnAction(e -> {
            Karyawan kar = new Karyawan(stage);
            kar.show();
        });
        Button tranksaksi = new Button("Transaksi");
        tranksaksi.getStyleClass().add("buton2");
        tranksaksi.setOnAction(e -> {
            Tranksaksi kasir = new Tranksaksi(stage);
            kasir.show();
        });
        Button hasill = new Button("Cetak Hasil");
        hasill.getStyleClass().add("buton2");
        hasill.setOnAction(e -> {
            Hasil cetak = new Hasil(stage);
            cetak.show();
        });
        Button home = new Button("Home");
        home.getStyleClass().add("home");
        home.setOnAction(e -> {
            Home pane = new Home(stage);
            pane.show();
        });
        

        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Color.web("#182527"));
        HBox rec = new HBox(rectangle);
        rec.setPadding(new Insets(0,0,0,0));


        Rectangle with = new Rectangle(1020, 650);
        with.setFill(Color.web("#ffff"));
        with.getStyleClass().add("rectangle");
        with.setArcWidth(30); // Mengatur lebar sudut
        with.setArcHeight(30);

        HBox rewc = new HBox(with);
        rewc.setPadding(new Insets(20,0,0,230));

        HBox home2 = new HBox(home);
        // home2.setAlignment(Pos.BOTTOM_RIGHT);
        VBox fungsi = new VBox(keuangan, barang, karyawan, tranksaksi, hasill, home2);
        fungsi.setSpacing(40);

        VBox vbox = new VBox(menu1, fungsi);
        
        vbox.setSpacing(40);
        vbox.setPadding(new Insets(10,10,10,10));
        salah = new Label();
        salah.getStyleClass().add("hasil");
 
        HBox gabungg = new HBox(90, vbox, sejajar);
        Pane pane = new Pane(rewc,rec2, gabungg, all, salah);
        pane.getStyleClass().add("background2");

        Scene scene = new Scene(pane);
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        stage.setScene(scene); 
        // stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.show();
        loadData();
    
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
        Stokbarang existingItem = findItemInRightTable(barang);
        if (existingItem != null) {
            existingItem.incrementStock();
        } else {
            selectedItems.add(new Stokbarang(barang.getNama(), barang.getHarga(), barang.getStok(), 0));
        }
        rightTableView.setItems(selectedItems);
        rightTableView.refresh(); // Refresh the table view to update the displayed stock
        updateTotal();
    }

    public Stokbarang findItemInRightTable(Barang barang) {
        for (Stokbarang item : selectedItems) {
            if (item.getNama().equals(barang.getNama())) {
                return item;
            }
        }
        return null;
    }

    public void incrementStock() {
        Stokbarang selectedItem = rightTableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            selectedItem.incrementStock();
            rightTableView.refresh(); // Refresh the table view to update the displayed stock
            updateTotal();
        }
    }

    public void decrementStock() {
        Stokbarang selectedItem = rightTableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null && selectedItem.getStock() > 0) {
            selectedItem.decrementStock();
            rightTableView.refresh(); // Refresh the table view to update the displayed stock
            updateTotal();
        }
    }

    public void deleteSelectedItem() {
        Stokbarang selectedItem = rightTableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            selectedItems.remove(selectedItem);
            rightTableView.refresh();
            updateTotal();
        }
    }

    public void processTransaction() {
        // Mengurangi stok pada tabel kiri dan database
        for (Stokbarang item : selectedItems) {
            Barang barang = findItemInLeftTable(item.getNama());
            if (item.getStock() >= 0) {
                int newStock = Integer.parseInt(barang.getStok()) - item.getStock();
                barang.setStok(String.valueOf(newStock));
                barangController.updateStok(barang.getNama(), newStock);
            } else {
                System.out.println("Jumlah stok barang kurang");
            }
        }
        selectedItems.clear();
        rightTableView.refresh();
        updateTotal();
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
        for (Stokbarang item : selectedItems) {
            if (item.getStock() >= 1) {
                total += Integer.parseInt(item.getHarga()) * item.getStock();
                try {
                    int nilaidiskon = Integer.parseInt(diskon.getText());
                    total = total - (total * nilaidiskon / 100);
                } catch (Exception e) {
                    System.out.println("Diskon tidak valid " + e.getMessage());
                }
            } else {
                // hasil.setOnAction(e -> {
                // salah.setText("Stok Kurang");
                // salah.relocate(800, 500);
                // });
            }
            totalLabel.setText("Total: " + total);
            hasilBelanja = total;
        }
    }

    public static class Stokbarang extends shopsense_app.scene.Barang {
        private final SimpleIntegerProperty stock;

        public Stokbarang(String nama, String harga, String stok, int initialStock) {
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

    public String waktu() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String waktu = now.format(formatter);
        return waktu;
    }

    private String cekNamaKaryawan(String id) {
        System.out.println("id = " + id);
        String data = "";
        ObservableList<Karyawan> karyawanslIST = selectAll();
        for (Karyawan karyawan : karyawanslIST){
            System.out.println(String.valueOf(karyawan.getId()));
            if (String.valueOf(karyawan.getId()).equals(id)) {
                data = karyawan.getNama();
            }
        }
        return data;
    }

    public ObservableList<Karyawan> selectAll() {
    	String sql = "SELECT nama, `id karyawan`, posisi, `tanggal masuk` FROM karyawan";
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

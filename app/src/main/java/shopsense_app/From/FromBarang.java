package shopsense_app.From;

import javafx.stage.Stage;
import javafx.scene.Scene;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.geometry.Pos;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import shopsense_app.scene.Barang;
import shopsense_app.scene.Karyawan;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.ScrollPane;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.collections.ObservableList;
import javafx.scene.control.TextFormatter;
import shopsense_app.fungsiMenu.DataProvider;
import shopsense_app.Data.DatabaseConnection2;
import shopsense_app.fungsiMenu.BarangController;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class FromBarang extends ListPaneBarang {

    VBox content;
    TextField tf_nama, tf_harga, tf_stok;
    Button add, update, delete, stok_barang, submit, cancel;
    BarangController barangController = new BarangController();

    ListPaneBarang listPane;
    TableView<shopsense_app.scene.Barang> tableView;
    
    public FromBarang(ListPaneBarang listPane) {
        this.listPane = listPane;
    }

    public VBox getFormPane() {
        add = new Button("Tambah Barang");
        add.getStyleClass().add("barang2");
        add.setMaxHeight(40);
        add.setMinWidth(200);
        add.setOnAction(e -> {
            setForm(1);
            setSubmit(1);
        });

        stok_barang = new Button("Perbarui Stok");
        stok_barang.setMaxHeight(40);
        stok_barang.setMinWidth(200);
        stok_barang.getStyleClass().add("barang2");
        stok_barang.setOnAction(e -> {
            setForm(4);
            setSubmit(4);
        });

        update = new Button("Perbarui Harga");
        update.setMaxHeight(40);
        update.setMinWidth(200);
        update.getStyleClass().add("barang2");
        update.setOnAction(e -> {
            setForm(2);
            setSubmit(2);
        });
        delete = new Button("Hapus");
        delete.getStyleClass().add("barang2");
        delete.setMaxHeight(40);
        delete.setMinWidth(200);
        delete.setOnAction(e -> {
            setForm(3);
            setSubmit(3);
        });
        content = new VBox();
        content.setSpacing(10);

        submit = new Button();
        submit.setPrefSize(200, 25);
        submit.getStyleClass().add("barangb");
        submit.setMinWidth(150);

        cancel = new Button("Cancel");
        cancel.setPrefSize(200, 25);
        cancel.setStyle("-fx-background-color: #0faf0f; -fx-text-fill: #ffffff;  -fx-background-radius: 10");
        cancel.setMinWidth(120);

        setForm(1);
        setSubmit(1);

        tableView = new TableView<>();
        TableColumn<Barang, String> namaColum = new TableColumn<>("NAMA BARANG");
        namaColum.setCellValueFactory(new PropertyValueFactory<>("nama"));
        namaColum.setPrefWidth(170);

        TableColumn<Barang, String> hargaColum = new TableColumn<>("HARGA BARANG");
        hargaColum.setCellValueFactory(new PropertyValueFactory<>("harga"));
        namaColum.setPrefWidth(160);

        TableColumn<Barang, String> stokColum = new TableColumn<>("STOK BARANG");
        stokColum.setCellValueFactory(new PropertyValueFactory<>("stok"));
        stokColum.setPrefWidth(115);

        VBox tab = new VBox(10, add,stok_barang, update, delete, submit);
        tab.setAlignment(Pos.TOP_CENTER);
        tab.maxWidth(160);

        tableView.getColumns().add(namaColum);
        tableView.getColumns().add(hargaColum);
        tableView.getColumns().add(stokColum);
        tableView.setMinWidth(400);

        Label barang = new Label("Barang");
        barang.getStyleClass().add("judul5");
        ScrollPane scrollPane = new ScrollPane(tableView);
        scrollPane.setMaxHeight(400);
        scrollPane.setMinWidth(400);
        VBox vbox = new VBox(20, content, scrollPane);
        vbox.setMaxHeight(400);
        vbox.setMaxWidth(400);
        vbox.setMinHeight(400);
        vbox.setMinWidth(400);
        vbox.setAlignment(Pos.TOP_CENTER);
        HBox res = new HBox(40, vbox, tab);
        res.setPadding(new Insets(20));
        res.setMaxHeight(600);
        res.setAlignment(Pos.CENTER);

        VBox last = new VBox(40, barang, res);
        last.setAlignment(Pos.CENTER);

        loadData();

        return last;
    }
    
    @Override
    public void loadData() {
        ObservableList<Barang> barang = barangController.selectAll();
        System.out.println(String.valueOf(barang.size()));
        tableView.setItems(barang);
    }

    void setForm(int type) {
        switch (type) {
            case 1 -> {
                content.getChildren().clear();
                Label lb_nama = new Label("Nama Barang");
                lb_nama.setPrefSize(100, 20);
                lb_nama.getStyleClass().add("barang");
                tf_nama = new TextField();
                tf_nama.setPrefSize(200, 20);
                tf_nama.setMinWidth(300);
                tf_nama.getStyleClass().add("ba");
                HBox nama = new HBox(lb_nama, tf_nama);
                Label lb_harga = new Label("Harga Barang");
                lb_harga.getStyleClass().add("barang");
                lb_harga.setPrefSize(100, 20);
                tf_harga = new TextField();
                tf_harga.setPrefSize(200, 20);
                tf_harga.setMinWidth(300);
                tf_harga.getStyleClass().add("ba");
                TextFormatter<String> textFormatter = new TextFormatter<>(change -> {
                    String newText = change.getControlNewText();
                    if (newText.matches("\\d*")) {
                        return change;
                    }
                    return null;
                });
                tf_harga.setTextFormatter(textFormatter);
                HBox harga = new HBox(lb_harga, tf_harga);
                Label lb_stok = new Label("Stok Barang");
                lb_stok.getStyleClass().add("barang");
                lb_stok.setPrefSize(100, 20);
                tf_stok = new TextField();
                tf_stok.setPrefSize(200, 20);
                TextFormatter<String> textFormatter1 = new TextFormatter<>(change -> {
                    String newText = change.getControlNewText();
                    if (newText.matches("\\d*")) {
                        return change;
                    }
                    return null;
                });
                tf_stok.setTextFormatter(textFormatter1);
                tf_stok.setMinWidth(300);
                tf_stok.getStyleClass().add("ba");
                HBox stok = new HBox(lb_stok, tf_stok);
                content.getChildren().addAll(nama, harga, stok);
            }
            case 2 -> {
                content.getChildren().clear();
                Label lb_nama = new Label("Nama Barang");
                lb_nama.getStyleClass().add("barang");
                lb_nama.setPrefSize(100, 20);
                ComboBox<Barang> tf_nama = new ComboBox<>();
                tf_nama.getStyleClass().add("ba");
                tf_nama.setCellFactory(param -> new ListCell<Barang>(){
                    public void updateItem(Barang item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                        } else {
                            setText(item.getNama());
                        }
                    }
                });

                tf_nama.setButtonCell(new ListCell<Barang>(){
                    public void updateItem(Barang item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                        } else {
                            setText(item.getNama());
                        }
                    }
                });

                tf_nama.setOnMouseClicked((MouseEvent event) -> {
                    ObservableList<Barang> barangList = selectAll();
                    tf_nama.setItems(barangList);
                });

                HBox nama = new HBox(lb_nama, tf_nama);
                Label lb_harga = new Label("Harga Barang");
                lb_harga.getStyleClass().add("barang");
                lb_harga.setPrefSize(100, 20);
                tf_harga = new TextField();
                tf_harga.setPrefSize(200, 20);
                TextFormatter<String> textFormatter = new TextFormatter<>(change -> {
                    String newText = change.getControlNewText();
                    if (newText.matches("\\d*")) {
                        return change;
                    }
                    return null;
                });
                tf_harga.setTextFormatter(textFormatter);
                tf_harga.getStyleClass().add("ba");
                tf_harga.setMinWidth(300);
                HBox harga = new HBox(lb_harga, tf_harga);
                content.getChildren().addAll(nama, harga);
            }
            case 3 -> {
                content.getChildren().clear();
                Label lb_nama = new Label("Nama Barang");
                lb_nama.getStyleClass().add("barang");
                lb_nama.setPrefSize(100, 20);
                ComboBox<Barang> tf_nama = new ComboBox<>();
                tf_nama.getStyleClass().add("ba");
                tf_nama.setCellFactory(param -> new ListCell<Barang>(){
                    public void updateItem(Barang item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                        } else {
                            setText(item.getNama());
                        }
                    }
                });

                tf_nama.setButtonCell(new ListCell<Barang>(){
                    public void updateItem(Barang item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                        } else {
                            setText(item.getNama());
                        }
                    }
                });

                tf_nama.setOnMouseClicked((MouseEvent event) -> {
                    ObservableList<Barang> barangList = selectAll();
                    tf_nama.setItems(barangList);
                });
                HBox nama = new HBox(lb_nama, tf_nama);
                content.getChildren().addAll(nama);
            }
            case 4 -> {
                content.getChildren().clear();
                Label lb_nama = new Label("Nama Barang");
                lb_nama.getStyleClass().add("barang");
                lb_nama.setPrefSize(100, 20);
                ComboBox<Barang> tf_nama = new ComboBox<>();
                tf_nama.getStyleClass().add("ba");
                tf_nama.setCellFactory(param -> new ListCell<Barang>(){
                    public void updateItem(Barang item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                        } else {
                            setText(item.getNama());
                        }
                    }
                });

                tf_nama.setButtonCell(new ListCell<Barang>(){
                    public void updateItem(Barang item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                        } else {
                            setText(item.getNama());
                        }
                    }
                });

                tf_nama.setOnMouseClicked((MouseEvent event) -> {
                    ObservableList<Barang> barangList = selectAll();
                    tf_nama.setItems(barangList);
                });

                HBox nama = new HBox(lb_nama, tf_nama);
                Label lb_stok = new Label("Stok Barang");
                lb_stok.getStyleClass().add("barang");
                lb_stok.setPrefSize(100, 20);
                tf_stok = new TextField();
                tf_stok.setPrefSize(200, 20);
                TextFormatter<String> textFormatter = new TextFormatter<>(change -> {
                    String newText = change.getControlNewText();
                    if (newText.matches("\\d*")) {
                        return change;
                    }
                    return null;
                });
                tf_stok.setTextFormatter(textFormatter);
                tf_stok.setMinWidth(300);
                tf_stok.getStyleClass().add("ba");
                HBox stok = new HBox(lb_stok, tf_stok);
                content.getChildren().addAll(nama, stok);
            }
        }
    }
    void setSubmit(int type) {
        switch (type) {
            case 1 -> {
                submit.setText("Tambah Data");
                submit.setOnAction(e -> {
                    String nama = ((TextField) ((HBox) content.getChildren().get(0)).getChildren().get(1)).getText().trim();
                    String harga = ((TextField) ((HBox) content.getChildren().get(1)).getChildren().get(1)).getText().trim();
                    String stok = ((TextField) ((HBox) content.getChildren().get(2)).getChildren().get(1)).getText().trim();
                    barangController.insert(nama, harga, stok);
                    if (!nama.isEmpty() || !harga.isEmpty() || !stok.isEmpty()) {
                        Barang barang = new Barang(nama, harga, stok);
                        DataProvider dataProvider = new DataProvider();
                        dataProvider.addBarang(barang);
                        tf_nama.clear();
                        tf_harga.clear();
                        tf_stok.clear();
                    }
                    tf_nama.setText("");
                    tf_harga.setText("");
                    tf_stok.setText("");
                    loadData();
                });
            }
            case 2 -> {
                submit.setText("Perbarui Data");
                submit.setOnAction(e -> {
                    Barang selectedBarang = ((ComboBox<Barang>) ((HBox) content.getChildren().get(0)).getChildren().get(1)).getValue();
                    if (selectedBarang != null) {
                        String nama = selectedBarang.getNama();
                        String harga = ((TextField) ((HBox) content.getChildren().get(1)).getChildren().get(1)).getText().trim();
                        
                        if (!harga.isEmpty()) {
                            try {
                                barangController.update(nama, harga);
                                selectedBarang.setHarga(harga);
                                tf_harga.clear();
                                tf_nama.clear();
                                loadData();
                            } catch (Exception ex) {
                                System.out.println("Error saat memperbarui data: " + ex.getMessage());
                            }
                        } else {
                            System.out.println("Input harga kosong");
                        }
                    } else {
                        System.out.println("Tidak ada barang yang dipilih");
                    }
                });
            }
            
            case 3 -> {
                submit.setText("Hapus Data");
                submit.setOnAction(e -> {
                    String nama = ((ComboBox<Barang>) ((HBox) content.getChildren().get(0)).getChildren().get(1)).getValue().getNama();
                    Stage stage = new Stage();
                    Button yes = new Button("Ya");
                    yes.setOnAction(e1 -> {
                        barangController.delete(nama);
                        loadData();
                        stage.close();
                    });
                    Button no = new Button("Tidak");
                    no.setOnAction(e1 -> stage.close());
                    HBox buton = new HBox(50, yes, no);
                    buton.setAlignment(Pos.CENTER);
                    VBox vBox = new VBox(new Label("Apakah Anda ingin Menghapus Barang?"), buton);
                    vBox.setSpacing(10);
                    vBox.setStyle("-fx-padding: 20px");
                    vBox.setPrefSize(300, 100);
                    Scene scene = new Scene(vBox);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                });
            }
            case 4 -> {
                submit.setText("Perbarui Data");
                submit.setOnAction(e -> {
                    Barang selectedBarang = ((ComboBox<Barang>) ((HBox) content.getChildren().get(0)).getChildren().get(1)).getValue();
                    if (selectedBarang != null) {
                        String nama = selectedBarang.getNama();
                        String stok = ((TextField) ((HBox) content.getChildren().get(1)).getChildren().get(1)).getText().trim();
                        if (!stok.isEmpty()) {
                            try {
                                int stokBaru = Integer.parseInt(stok);
                                Barang barang = barangController.getBarangByNama(nama);
                                if (barang != null) {
                                    int stokLama = Integer.parseInt(barang.getStok());
                                    int total = stokLama + stokBaru;
                                    barangController.updateStok(nama,String.valueOf(total));
                                    tf_stok.clear();
                                    loadData();
                                }
                            } catch (NumberFormatException ex) {
                                System.out.println("input berupa angka");
                            }
                        }
                    }
                });
            }       

        }
    }
    private String cekNamaBarang(String nama) {
        String data = "";
        ObservableList<Barang> barangList = selectAll();
        for (Barang barang : barangList){
            System.out.println(barang.getNama()); // Mengakses properti nama dari objek barang
            if (barang.getNama().equals(nama)) { // Membandingkan nama barang dari objek barang dengan nama yang diberikan
                data = barang.getNama();
            }
        }
        return data;
    }
    
    public ObservableList<Barang> selectAll() {
    	String sql = "SELECT nama, harga, stok FROM barang";
    	ObservableList<Barang> data = FXCollections.observableArrayList();
    	try (Connection conn = DatabaseConnection2.connect();
         	Statement stmt = conn.createStatement();
         	ResultSet rs = stmt.executeQuery(sql)) {
        	while (rs.next()) {
            	Barang barang = new Barang(
                    	rs.getString("nama"),
                    	rs.getString("harga"),
                    	rs.getString("stok")
            	);
            	data.add(barang);
        	}
    	} catch (SQLException e) {
        	System.out.println(e.getMessage());
    	}
    	return data;
	}
}
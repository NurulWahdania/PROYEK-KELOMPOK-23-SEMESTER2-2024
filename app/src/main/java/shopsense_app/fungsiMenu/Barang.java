package shopsense_app.fungsiMenu;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import shopsense_app.scenes.Menuisi;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import shopsense_app.scenes.FormPane;
import shopsense_app.scenes.FromBarang;
import shopsense_app.scenes.ListPaneBarang;
import javafx.beans.property.SimpleStringProperty;

public class Barang {
    private SimpleStringProperty nama;
    private SimpleStringProperty harga;
    private SimpleStringProperty stok;
    Stage stage;
    public Barang(String nama, String harga, String stok, Stage stage) {
        this.nama = new SimpleStringProperty(nama);
        this.harga = new SimpleStringProperty(harga);
        this.stok = new SimpleStringProperty(stok);
        this.stage = stage;
    }
    public Barang(String nama, String harga, String stok) {
        this.nama = new SimpleStringProperty(nama);
        this.harga = new SimpleStringProperty(harga);
        this.stok = new SimpleStringProperty(stok);
    }
    public Barang(Stage stage) {
        this.stage = stage;
    }
    public String getNama() {
        return nama.get();
    }
    public void setNama(String nama) {
        this.nama.set(nama);
    }
    public String getHarga() {
        return harga.get();
    }
    public void setHarga(String harga) {
        this.harga.set(harga);
    }
    public String getStok() {
        return stok.get();
    }
    public void setStok(String stok) {
        this.stok.set(stok);
    }

    public void show() {

        Label nmToko = new Label(FormPane.namaToko);
        nmToko.getStyleClass().add("tokok2");
        Line line = new Line();
        line.setStartY(0);
        line.setStartX(20);
        line.setEndY(20);
        line.setEndX(20);
        line.setStrokeWidth(2);
        line.setStroke(Color.BLACK);
        HBox lin2 = new HBox(line);

        ListPaneBarang listPane = new ListPaneBarang();
        FromBarang fromPane2 = new FromBarang(listPane);

        Pane formPaneContainer = new Pane(fromPane2.getFormPane());
        formPaneContainer.setPadding(new Insets(40));
        Button home = new Button("menu");
        home.getStyleClass().add("home");
        home.setOnAction(e -> {
            Menuisi menu = new Menuisi(stage);
            menu.show();
        });
        // Create a VBox to stack formPaneContainer and the home button vertically
        VBox vBox = new VBox(10); // 10 is the spacing between elements
        vBox.getChildren().addAll(formPaneContainer, home);
        vBox.setPadding(new Insets(40));
        vBox.setStyle("-fx-background-color: #ccf4e5");
        // Align the home button to the bottom-right
        VBox.setVgrow(formPaneContainer, Priority.ALWAYS);
        vBox.setAlignment(Pos.TOP_CENTER);

        HBox all2 = new HBox(10, lin2, nmToko);
        all2.setPadding(new Insets(10,0,0,20));

        VBox box = new VBox(all2,vBox);

        // Wrap the VBox in another layout to control the overall alignment and padding
        StackPane stackPane = new StackPane(box, home);
        // StackPane.setMargin(nmToko1, new Insets(-540, 0, 0, -760));
        StackPane.setAlignment(home, Pos.BOTTOM_RIGHT);
        StackPane.setMargin(home, new Insets(10));
        stackPane.getStyleClass().add("backgroundB");

        Scene scene = new Scene(stackPane, 800, 600);
        
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
package shopsense_app.fungsiMenu;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import shopsense_app.scenes.FromPane2;
import shopsense_app.scenes.ListPane2;
import shopsense_app.scenes.Menuisi;

public class Barang {
    private String nama;
    private String harga;
    private String stok;
    Stage stage;

    public Barang(Stage stage){
        this.stage = stage;
    }
       

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public Barang(String nama, String harga, String stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public void show(){

        // ListPane2 listPane = new ListPane2();
        // FromPane2 fromPane2 = new FromPane2(listPane);

        // Pane hBox = new Pane(fromPane2.getFormPane());
        // hBox.setPadding(new Insets(40));
        // hBox.setStyle("-fx-background-color: #ccf4e5");

        // Button home = new Button("Home");
        // home.getStyleClass().add("home2");
        // home.setOnAction(e -> {
        //     Menuisi menu = new Menuisi(stage);
        //     menu.show();
        // });

        // VBox home2 = new VBox(home);
        // home2.setAlignment(Pos.BOTTOM_RIGHT);
        // home2.setPadding(new Insets(0, 0, 0, 0));

        // VBox all = new VBox(hBox,home2);
        // all.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());

        // Scene scene = new Scene(all, 800, 600);
        // stage.setScene(scene);
        // stage.setResizable(false);
        // stage.show();


        ListPane2 listPane = new ListPane2();
        FromPane2 fromPane2 = new FromPane2(listPane);
        
        Pane formPaneContainer = new Pane(fromPane2.getFormPane());
        formPaneContainer.setPadding(new Insets(40));
        formPaneContainer.setStyle("-fx-background-color: #ccf4e5");
        
        Button home = new Button("Home");
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
        
        // Wrap the VBox in another layout to control the overall alignment and padding
        StackPane stackPane = new StackPane(vBox, home);
        StackPane.setAlignment(home, Pos.BOTTOM_RIGHT);
        StackPane.setMargin(home, new Insets(10));

        
        
        Scene scene = new Scene(stackPane, 800, 600);
        stackPane.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        

    }

    


}


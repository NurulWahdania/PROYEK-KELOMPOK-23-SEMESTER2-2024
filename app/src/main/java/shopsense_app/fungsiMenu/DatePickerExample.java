package shopsense_app.fungsiMenu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class DatePickerExample extends Application {

    @Override
    public void start(Stage stage) {
        DatePicker datePicker = new DatePicker();
        
        Label selectedDateLabel = new Label();

        Button getDateButton = new Button("Get Date");
        getDateButton.setOnAction(e -> {
            LocalDate selectedDate = datePicker.getValue();
            if (selectedDate != null) {
                selectedDateLabel.setText("Selected Date: " + selectedDate.toString());
            } else {
                selectedDateLabel.setText("No Date Selected");
            }
        });

        VBox layout = new VBox(10, datePicker, getDateButton, selectedDateLabel);
        layout.setPadding(new javafx.geometry.Insets(10));

        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.setTitle("DatePicker Example");
        stage.show();
    }

}

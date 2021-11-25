package ui.panes;

import java.time.LocalDate;

import javax.swing.GroupLayout.Alignment;

import booking_system.Booking;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import ui.UI;

public class CancelBookingUI extends VBox{
    public CancelBookingUI(UI baseUI) {
        Text title = new Text("Cancel Booking Screen");
        title.getStyleClass().add("title");

        HBox centeredTitle = new HBox(title);
        centeredTitle.setAlignment(Pos.CENTER);

        getChildren().add(centeredTitle);
        setSpacing(UI.DEFAULT_SPACING);
        setPadding(new Insets(UI.DEFAULT_SPACING));
    }
}

package ui.panes;
import java.time.LocalDate;

import booking_system.Booking;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import ui.UI;

public class DataUI extends VBox {

    @SuppressWarnings("unchecked")
    public DataUI(UI baseUI) {
        TableView<Booking> table = new TableView<>();

        table.setEditable(true);

        
        TableColumn<Booking, String> nameCol = new TableColumn<>("Name");
        TableColumn<Booking, String> emailCol = new TableColumn<>("Email");
        TableColumn<Booking, LocalDate> checkInCol = new TableColumn<>("Check In");
        TableColumn<Booking, LocalDate> checkOutCol = new TableColumn<>("Check Out");
        TableColumn<Booking, LocalDate> isApPurchase = new TableColumn<>("Advanced Purchase");
        TableColumn<Booking, LocalDate> numberOfRooms = new TableColumn<>("Total Rooms");
        TableColumn<Booking, LocalDate> totalCost = new TableColumn<>("Total Cost");
    

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        checkInCol.setCellValueFactory(new PropertyValueFactory<>("checkInDate"));
        checkOutCol.setCellValueFactory(new PropertyValueFactory<>("checkOutDate"));
        isApPurchase.setCellValueFactory(new PropertyValueFactory<>("isApPurchase"));
        numberOfRooms.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
        totalCost.setCellValueFactory(new PropertyValueFactory<>("numberOfRooms"));
        
        table.getColumns().addAll(nameCol, emailCol, checkInCol, checkOutCol, isApPurchase, numberOfRooms, totalCost);
        table.getItems().addAll(baseUI.getBookingSystem().getBookings());
        
        VBox.setVgrow(table, Priority.ALWAYS);

        getChildren().add(table);
        setSpacing(UI.DEFAULT_SPACING);
        setPadding(new Insets(UI.DEFAULT_SPACING));
    }
}

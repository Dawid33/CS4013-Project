package ui.panes;

import java.io.IOException;
import java.time.LocalDate;

import booking_system.Booking;
import booking_system.Room;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ui.UI;

public class ManageBookingUI extends VBox{

    TableView<Booking> table = new TableView<>();
    TableView<Room> rooms = new TableView<>();

    ObservableList<Booking> currentlySelectedCells = null;

    @SuppressWarnings("unchecked")
    public ManageBookingUI(UI baseUI) {
        Text title = new Text("Cancel Booking Screen");
        title.getStyleClass().add("title");
        HBox centeredTitle = new HBox(title);
        centeredTitle.setAlignment(Pos.CENTER);
        getChildren().add(centeredTitle);

        table.setEditable(true);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

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

        TableColumn<Room, String> roomCol = new TableColumn<>("Room Type");
        TableColumn<Room, String> roomOccupancyCol = new TableColumn<>("Number of People");

        roomCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        roomOccupancyCol.setCellValueFactory(new PropertyValueFactory<>("occupancy"));

        rooms.getColumns().addAll(roomCol, roomOccupancyCol);

        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                if(table.getSelectionModel().getSelectedItem() != null) {    
                   TableViewSelectionModel selectionModel = table.getSelectionModel();
                   currentlySelectedCells = selectionModel.getSelectedItems();
                    if(currentlySelectedCells.size() == 1) {
                        rooms.getItems().clear();
                        rooms.getItems().addAll(((Booking)currentlySelectedCells.get(0)).getRooms());
                    }   
                }
            }
        });

        Button button = new Button("Delete Selected");
        button.setOnMouseClicked((event) -> {
            if (this.currentlySelectedCells != null) {
                table.getItems().removeAll(currentlySelectedCells);
                currentlySelectedCells.forEach((e) -> {
                    baseUI.getBookingSystem().removeBooking(e);
                });
                rooms.getItems().clear();
                try {
                    baseUI.getBookingSystem().updateBookingsToFile();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        });

        HBox bottomBar = new HBox(button);
        bottomBar.setSpacing(10);
        bottomBar.setPadding(new Insets(0, 10, 0, 0));
        bottomBar.setAlignment(Pos.CENTER_RIGHT);

        getChildren().addAll(table, rooms, bottomBar);
        setSpacing(UI.DEFAULT_SPACING);
        setPadding(new Insets(UI.DEFAULT_SPACING));
    }
}
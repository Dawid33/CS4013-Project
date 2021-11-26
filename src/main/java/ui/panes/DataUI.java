package ui.panes;
import java.time.LocalDate;
import java.util.ArrayList;

import booking_system.Booking;
import booking_system.Room;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ui.UI;

public class DataUI extends VBox {

    TableView<Booking> table = new TableView<>();;
    TableView<Room> rooms = new TableView<>();;

    @SuppressWarnings("unchecked")
    public DataUI(UI baseUI) {
        Text title = new Text("Data Viewing");
        title.getStyleClass().add("title");
        HBox centeredTitle = new HBox(title);
        centeredTitle.setAlignment(Pos.CENTER);
        getChildren().add(centeredTitle);

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

        TableColumn<Room, String> roomCol = new TableColumn<>("Room Type");
        TableColumn<Room, String> roomOccupancyCol = new TableColumn<>("Number of People");

        roomCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        roomOccupancyCol.setCellValueFactory(new PropertyValueFactory<>("occupancy"));

        rooms.getColumns().addAll(roomCol, roomOccupancyCol);

        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                //Check whether item is selected and set value of selected item to Label
                if(table.getSelectionModel().getSelectedItem() != null) {    
                   TableViewSelectionModel selectionModel = table.getSelectionModel();
                   ObservableList selectedCells = selectionModel.getSelectedItems();
                   if(selectedCells.size() == 1) {
                       setRoomData(((Booking)selectedCells.get(0)).getRooms());
                   }
                   //TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                   //Object val = tablePosition.getTableColumn().getCellData(newValue);
                   //System.out.println("Selected Value" + val);
                }
            }
        });

        VBox box = new VBox(table, rooms);
        ScrollPane pane = new ScrollPane(box);
        getChildren().addAll(pane);
        setSpacing(UI.DEFAULT_SPACING);
        setPadding(new Insets(UI.DEFAULT_SPACING));
    }

    public void setRoomData(ArrayList<Room> newRooms) {
        rooms.getItems().clear();
        rooms.getItems().addAll(newRooms);
    }
}

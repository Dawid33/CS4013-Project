package ui.panes;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

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

public class AnalysisUI extends VBox {

    TableView<Booking> analyticsTable = new TableView<>();
    
    ArrayList<Booking> currentlySelectedCells = null;

    @SuppressWarnings("unchecked")
    public AnalysisUI(UI baseUI) {
        Text title = new Text("Analysis Screen");
        title.getStyleClass().add("title");

        HBox centeredTitle = new HBox(title);
        centeredTitle.setAlignment(Pos.CENTER);
        
        analyticsTable.setEditable(true);
        analyticsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        TableColumn<Booking, String> htypeCol = new TableColumn<>("Hotel type");
        TableColumn<Booking, String> rtypeCol = new TableColumn<>("Room type");
        TableColumn<Booking, Integer> occupancyCol = new TableColumn<>("Total occupancy");
        TableColumn<Booking, Integer> profitCol = new TableColumn<>("Total profit");
        TableColumn<Booking, Integer> averageCol = new TableColumn<>("Profit average");

        htypeCol.setCellValueFactory(new PropertyValueFactory<>("hotel"));
        rtypeCol.setCellValueFactory(new PropertyValueFactory<>("room"));
        occupancyCol.setCellValueFactory(new PropertyValueFactory<>("totalOccupancy"));
        profitCol.setCellValueFactory(new PropertyValueFactory<>("totalProfit"));
        averageCol.setCellValueFactory(new PropertyValueFactory<>("profitAverage"));
        
        analyticsTable.getColumns().addAll(htypeCol, rtypeCol, occupancyCol, profitCol);
        analyticsTable.getItems().addAll(baseUI.getBookingSystem().getBookings());
        
        getChildren().addAll(centeredTitle,analyticsTable);

        }

}

package ui.panes;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import analytic.Analytics;
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

    TableView<Analytics> analyticsTable = new TableView<>();
    
    ArrayList<Analytics> currentlySelectedCells = null;

    @SuppressWarnings("unchecked")
    public AnalysisUI(UI baseUI) {
        Text title = new Text("Analysis Screen");
        title.getStyleClass().add("title");

        HBox centeredTitle = new HBox(title);
        centeredTitle.setAlignment(Pos.CENTER);
        
        analyticsTable.setEditable(true);
        analyticsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        TableColumn<Analytics, String> htypeCol = new TableColumn<>("Hotel type");
        TableColumn<Analytics, String> rtypeCol = new TableColumn<>("Room type");
        TableColumn<Analytics, Integer> occupancyCol = new TableColumn<>("Total occupancy");
        TableColumn<Analytics, Integer> profitCol = new TableColumn<>("Total profit");
        TableColumn<Analytics, Integer> averageCol = new TableColumn<>("Profit average");

        htypeCol.setCellValueFactory(new PropertyValueFactory<>("hotel"));
        rtypeCol.setCellValueFactory(new PropertyValueFactory<>("room"));
        occupancyCol.setCellValueFactory(new PropertyValueFactory<>("totalOccupancy"));
        profitCol.setCellValueFactory(new PropertyValueFactory<>("totalProfit"));
        averageCol.setCellValueFactory(new PropertyValueFactory<>("profitAverage"));
        
        analyticsTable.getColumns().addAll(htypeCol, rtypeCol, occupancyCol, profitCol, averageCol);
        analyticsTable.getItems().addAll();
        
        getChildren().addAll(centeredTitle,analyticsTable);
        
        
        }

}

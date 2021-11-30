package ui.panes;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import analytics.Analytics;
import booking_system.Booking;
import booking_system.Room;
import core.Program;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

        TableColumn<Booking, String> nameCol = new TableColumn<>("Name");
        TableColumn<Booking, String> emailCol = new TableColumn<>("Email");
        TableColumn<Booking, LocalDate> checkInCol = new TableColumn<>("Check In");
        TableColumn<Booking, LocalDate> checkOutCol = new TableColumn<>("Check Out");
        TableColumn<Booking, LocalDate> creationDateCol = new TableColumn<>("Booking Creation Date");
        TableColumn<Booking, LocalDate> isApPurchase = new TableColumn<>("Advanced Purchase");
        TableColumn<Booking, LocalDate> numberOfRooms = new TableColumn<>("Total Rooms");
        TableColumn<Booking, LocalDate> totalCost = new TableColumn<>("Total Cost");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        checkInCol.setCellValueFactory(new PropertyValueFactory<>("checkInDate"));
        checkOutCol.setCellValueFactory(new PropertyValueFactory<>("checkOutDate"));
        creationDateCol.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
        isApPurchase.setCellValueFactory(new PropertyValueFactory<>("isApPurchase"));
        numberOfRooms.setCellValueFactory(new PropertyValueFactory<>("numberOfRooms"));
        totalCost.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
        
        analyticsTable.getColumns().addAll(nameCol, emailCol, checkInCol, checkOutCol, creationDateCol, isApPurchase, numberOfRooms, totalCost);
        analyticsTable.getItems().addAll(baseUI.getBookingSystem().getBookings());
        analyticsTable.getItems().addAll(baseUI.getBookingSystem().getBookingsArchives());
        
        getChildren().addAll(centeredTitle,analyticsTable);

        analyticsTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                currentlySelectedCells = new ArrayList<>(analyticsTable.getSelectionModel().getSelectedItems());
            }
        });

        Label profitValue = new Label();
        Label averageValue = new Label();

        Button totalProfit = new Button("Calculate Gross Total Of Selected");
        totalProfit.setOnMouseClicked((event) -> {
            if (currentlySelectedCells != null && currentlySelectedCells.size() > 0) {
                profitValue.setText(Analytics.getTotalProfit(currentlySelectedCells).toString());
            }
        });

        Button profitAverage = new Button("Calculate Averge Per Booking Of Selected");
        profitAverage.setOnMouseClicked((event) -> {
            if (currentlySelectedCells != null && currentlySelectedCells.size() > 0) {
                averageValue.setText(Analytics.getProfitAverage(currentlySelectedCells).toString());
            }
        });

        HBox analysisBox = new HBox(totalProfit, profitAverage);
        analysisBox.setAlignment(Pos.CENTER_RIGHT);
        analysisBox.setPadding(new Insets(UI.DEFAULT_SPACING));
        analysisBox.setSpacing(UI.DEFAULT_SPACING);
        
        getChildren().addAll(analysisBox);

        Label profit = new Label("Gross total :");
        Label average = new Label("Average : ");

        HBox bottomText = new HBox(profit, profitValue, average, averageValue);
        bottomText.setPadding(new Insets(UI.DEFAULT_SPACING));
        bottomText.setSpacing(UI.DEFAULT_SPACING);

        getChildren().addAll(bottomText);
        
        }
}

package ui.builders;

import core.Program;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import ui.UI;

public class HelpUI extends VBox {
    static String introductionRaw = 
    "This section contains an overview on how to use various parts of this software. The latter half contains a section which describes common actions.";
    static String reservationTextRaw = 
    "How to make a reservation";
    static String cancelReservationRaw = 
    "How to cancel a reservation";

    public HelpUI(UI baseUI) {
        Text title = new Text("Help Screen");
        title.getStyleClass().add("title");

        HBox centeredTitle = new HBox(title);
        centeredTitle.setAlignment(Pos.CENTER);

        Text introduction = new Text(introductionRaw);
        //TODO: Figure out how to do word wrap correctly, this is jank.
        introduction.setWrappingWidth(Program.MIN_APPLICATION_WIDTH - Program.MIN_APPLICATION_WIDTH * 0.3);
        introduction.setTextAlignment(TextAlignment.JUSTIFY);

        Label reservationText = new Label(reservationTextRaw);
        TitledPane reservation = new TitledPane("How to make a reservation", reservationText);
    
        Label cancelReservationText = new Label(cancelReservationRaw);
        TitledPane cancelReservation = new TitledPane("How to cancel a reservation", cancelReservationText);

        getChildren().addAll(centeredTitle, introduction, reservation, cancelReservation);
        setAlignment(Pos.TOP_LEFT);
        setSpacing(UI.DEFAULT_SPACING);
        setPadding(new Insets(UI.DEFAULT_SPACING));
    }
}

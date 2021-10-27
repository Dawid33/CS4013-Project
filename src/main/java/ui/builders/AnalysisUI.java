package ui.builders;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import ui.UI;

public class AnalysisUI extends VBox {
    public AnalysisUI(UI baseUI) {
        Text title = new Text("Analysis Screen");
        title.getStyleClass().add("title");

        HBox centeredTitle = new HBox(title);
        centeredTitle.setAlignment(Pos.CENTER);
        
        getChildren().add(centeredTitle);
        setSpacing(UI.DEFAULT_SPACING);
        setPadding(new Insets(UI.DEFAULT_SPACING));
    }
}

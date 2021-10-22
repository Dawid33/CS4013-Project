package ui;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;


public class MainMenuUI extends SceneUI {
    public MainMenuUI(UIManager manager) {
        
        Label companyLabel = new Label("BestSolutions");
        companyLabel.setFont(new Font(UIManager.COMPANY_TITLE_FONT_SIZE));

        Button makeReservation = new Button("Make Reservation");
        makeReservation.setPrefSize(150, 50);
        makeReservation.setOnMouseClicked((event) -> {
            System.out.println("New Scene, reservation ui");
            manager.setScene(new ReservationsUI(manager));
        });

        Button viewAnalysis = new Button("Analysis");
        viewAnalysis.setPrefSize(150, 50);
        viewAnalysis.setOnMouseClicked((event) -> {
            System.out.println("New Scene, analysis ui");
            manager.setScene(new AnalysisUI(manager));
        });
        
        this.contentPanel.getChildren().addAll(
            companyLabel,
            makeReservation,
            viewAnalysis
        );
    }
}

package ale.neo.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private VBox vbCenter;

    @FXML
    private VBox vbLeft;

    @FXML
    private VBox vbRight;

    @FXML
    private VBox vbBottom;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            BorderPane bpCenter = FXMLLoader.load(getClass().getResource("/ale/neo/gui/template/module/module_code.fxml"));
            vbCenter.getChildren().setAll(bpCenter);

            BorderPane bpLeft = FXMLLoader.load(getClass().getResource("/ale/neo/gui/template/module/module_explorer.fxml"));
            vbLeft.getChildren().setAll(bpLeft);

            BorderPane bpRight = FXMLLoader.load(getClass().getResource("/ale/neo/gui/template/module/module_analyzer.fxml"));
            vbRight.getChildren().setAll(bpRight);

            BorderPane bpBottom = FXMLLoader.load(getClass().getResource("/ale/neo/gui/template/module/module_output.fxml"));
            vbBottom.getChildren().setAll(bpBottom);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

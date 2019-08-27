package ale.neo.controller;

import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.ScrollEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CodeController implements Initializable {

    @FXML
    private TextArea taSourceCode;

    @FXML
    private TextArea taLineNumber;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taLineNumber.setText("1");

        taSourceCode.textProperty().addListener(taSourceCodeChangeListener);
        taSourceCode.setOnScroll(taSourceCodeOnScroll);
    }

    private final ChangeListener<String> taSourceCodeChangeListener = (observable, oldValue, newValue) -> {
        int lineCount = taSourceCode.getParagraphs().size();
        var lines = new StringBuilder();

        for (int i = 1; i <= lineCount; i++)
            lines.append(i).append('\n');

        taLineNumber.setText(lines.toString());
    };

    private EventHandler<? super ScrollEvent> taSourceCodeOnScroll = event -> {
        double scrollAmount = taSourceCode.getScrollTop();

        System.out.println("Scroll amount is: " + scrollAmount);

        taLineNumber.setScrollTop(scrollAmount);
    };

}

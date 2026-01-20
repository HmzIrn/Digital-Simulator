module com.DigitalSimulator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens DigitalSimulator to javafx.fxml;
    exports DigitalSimulator;
}
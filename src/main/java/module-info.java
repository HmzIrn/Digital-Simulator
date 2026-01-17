module com.DigitalSimulator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.DigitalSimulator to javafx.fxml;
    exports com.DigitalSimulator;
}
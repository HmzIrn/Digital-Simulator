module com.javafxdemo.digitalsimulator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.javafxdemo.digitalsimulator to javafx.fxml;
    exports com.javafxdemo.digitalsimulator;
}
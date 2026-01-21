package DigitalSimulator;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PortNode extends Circle {
    public final PortType direction;

    public PortNode(PortType dir, double x, double y) {
        super(x, y, 2);
        this.direction = dir;
        setFill(Color.RED);

        this.setOnMouseClicked(event -> {
            fireEvent(new PortEvent(this));
        });
    }
}


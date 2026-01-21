package DigitalSimulator;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class GateNode extends Group{
    private final SVGPath Symbol;
    private PortNode inA, inB;
    private PortNode outC;

    private double offsetX;
    private double offsetY;

    public GateNode(GateType type){
        Symbol = new SVGPath();

        inA = new PortNode(PortType.INPUT, -10, 10);
        inB = new PortNode(PortType.INPUT, -10, 30);
        outC = new PortNode(PortType.OUTPUT, 70, 20);

        Symbol.setContent(type.getSvgPath());
        Symbol.setFill(Color.WHITE);
        Symbol.setStroke(Color.BLACK);
        Symbol.setStrokeWidth(3);

        getChildren().add(Symbol);
        getChildren().addAll(inA, inB, outC);

        this.setOnMousePressed(event -> {
            // Calculate how far the mouse is from the node's (0,0)
            offsetX = event.getSceneX() - this.getLayoutX();
            offsetY = event.getSceneY() - this.getLayoutY();
        });

        this.setOnMouseDragged(event -> {
            // We use getScene coordinates to move relative to the window, not the node itself
            this.setLayoutX(event.getSceneX() - offsetX);
            this.setLayoutY(event.getSceneY() - offsetY);
        });
    }
}

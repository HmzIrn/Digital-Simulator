package com.DigitalSimulator;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class GateNode extends Group {
    private final GateType Type;
    private final SVGPath Symbol;
    private PortNode inA, inB;
    private PortNode outC;

    public GateNode(GateType type){
        Type = type;
        Symbol = new SVGPath();

        inA = new PortNode(PortType.INPUT, -10, 10);
        inB = new PortNode(PortType.INPUT, -10, 30);
        outC = new PortNode(PortType.INPUT, 70, 20);

        switch (Type){
            case AND -> Symbol.setContent("M-10 10 L0 10 M-10 30 L0 30 M50 20 L70 20 M0 0 L30 0" +
                    " A20 20 0 0 1 30 40 L0 40 Z"
            );

            case OR -> Symbol.setContent("M-10 10 L5 10 M-10 30 L5 30 M45 20 L70 20 M0 0 Q20 20 0" +
                    " 40 Q25 40 45 20 Q25 0 0 0 Z"
            );

            case NAND -> Symbol.setContent("M-10 10 L0 10 M-10 30 L0 30 M60 20 L70 20 M0 0 L30 0" +
                    " A20 20 0 0 1 30 40 L0 40 Z M59 20 A4 4 0 1 1 51 20 A4 4 0 1 1 59 20"
            );

            case NOR -> Symbol.setContent("M-10 10 L5 10 M-10 30 L5 30 M53 20 L70 20 M0 0 Q20 20 0" +
                    " 40 Q25 40 45 20 Q25 0 0 0 Z M53 20 A4 4 0 1 1 45 20 A4 4 0 1 1 53 20"
            );
        }

        Symbol.setFill(Color.WHITE);
        Symbol.setStroke(Color.BLACK);
        Symbol.setStrokeWidth(3);

        getChildren().add(Symbol);
        getChildren().addAll(inA, inB, outC);
    }
}

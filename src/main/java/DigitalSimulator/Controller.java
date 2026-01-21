package DigitalSimulator;

import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private Pane workspace;
    List<GateNode> Gates = new ArrayList<>();
    List<Wire> Wires = new ArrayList<>();

    private Wire activeWire;

    public ToolType activeTool;
    private GateType activeGate;

    public void initialize(){
        workspace.setOnMouseClicked(mouseEvent -> {
            if (activeTool == ToolType.Gate){
                switch (activeGate){
                    case AND -> Gates.add(new GateNode(GateType.AND));
                    case OR -> Gates.add(new GateNode(GateType.OR));
                    case NAND -> Gates.add(new GateNode(GateType.NAND));
                    case NOR -> Gates.add(new GateNode(GateType.NOR));
                }
                Gates.getLast().setLayoutX(mouseEvent.getX() - 40);
                Gates.getLast().setLayoutY(mouseEvent.getY() - 20);
                workspace.getChildren().add(Gates.getLast());
            }
        } );

        workspace.addEventHandler(PortEvent.PORT_CLICKED, e -> {
            PortNode port = e.port;
            System.out.println("PORT EVENT RECEIVED");
            System.out.println("Tool = " + activeTool);

            if (activeTool != ToolType.Wire)
                return;
            else if (activeWire == null && port.direction == PortType.OUTPUT) {
                activeWire = new Wire(port);
                workspace.getChildren().add(activeWire);
                System.out.println("Start");
                activeWire.updateStart();

            } else if (activeWire != null && port.direction == PortType.INPUT) {

                activeWire.attachEnd(port);
                Wires.add(activeWire);
                activeWire = null;
                System.out.println("End");
            }
        });

        workspace.setOnMouseMoved(e -> {
            if (activeWire != null) {
                activeWire.updatePreview(
                        new Point2D(e.getSceneX(), e.getSceneY())
                );
            }
        });
    }

    public void andToggle(){
        activeGate = GateType.AND;
    }

    public void orToggle(){
        activeGate = GateType.OR;
    }

    public void nandToggle(){
        activeGate = GateType.NAND;
    }

    public void norToggle(){
        activeGate = GateType.NOR;
    }

    public void selToggle(){
        activeTool = ToolType.Select;
    }

    public void gateToggle(){
        activeTool = ToolType.Gate;
    }

    public void wireToggle(){
        activeTool = ToolType.Wire;
    }
}

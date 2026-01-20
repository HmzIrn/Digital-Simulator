package DigitalSimulator;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private Pane workspace;
    List<GateNode> Gates = new ArrayList<>();

    private GateType activeGate;
    private ToolType activeTool;

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

package com.DigitalSimulator;

import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Simulator extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);
        root.setPrefHeight(600);
        root.setPrefWidth(1000);

        // Adding Panes to root
        root.setTop(BuildTopBar());
        root.setLeft(BuildToolPane());
        root.setCenter(BuildWorkspace());

        // Main Stage
        stage.setTitle("Simulator");
        stage.setScene(scene);
        stage.show();
    }

    public HBox BuildTopBar(){
        HBox top = new HBox();
        top.setPrefHeight(40);
        top.setStyle("-fx-background-color: #f50000;");

        return top;
    }

    public VBox BuildToolPane(){
        VBox toolPane = new VBox();
        toolPane.setPrefWidth(200);
        toolPane.setStyle("-fx-background-color: #45f500;");

        return toolPane;
    }

    public Pane BuildWorkspace(){
        Pane workspace = new Pane();
        workspace.setStyle("-fx-background-color: #0004f5;");
        GateNode gate = new GateNode(GateType.AND);
        workspace.getChildren().add(gate);
        gate.setLayoutX(100);
        gate.setLayoutY(100);

        GateNode gate2 = new GateNode(GateType.OR);
        workspace.getChildren().add(gate2);
        gate2.setLayoutX(400);
        gate2.setLayoutY(100);

        GateNode gate3 = new GateNode(GateType.NAND);
        workspace.getChildren().add(gate3);
        gate3.setLayoutX(100);
        gate3.setLayoutY(400);

        GateNode gate4 = new GateNode(GateType.NOR);
        workspace.getChildren().add(gate4);
        gate4.setLayoutX(400);
        gate4.setLayoutY(400);

        return workspace;
    }
}

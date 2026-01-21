package DigitalSimulator;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Wire extends Path {

    private final PortNode startPort;
    private PortNode endPort;

    private final MoveTo moveTo = new MoveTo();
    private final LineTo lineTo = new LineTo();

    public Wire(PortNode startPort) {

        this.startPort = startPort;

        getElements().addAll(moveTo, lineTo);

        setStroke(Color.BLACK);
        setStrokeWidth(2);
        setMouseTransparent(true);

        // listen to start port movement
        startPort.localToSceneTransformProperty().addListener((obs, o, n) -> updateStart());
    }

    public void attachEnd(PortNode endPort) {
        this.endPort = endPort;

        endPort.localToSceneTransformProperty().addListener((obs, o, n) -> updateEnd());

        updateEnd();
    }


    public void updateStart() {
        if (getParent() == null) return;

        Point2D p = getParent().sceneToLocal(
                startPort.localToScene(
                        startPort.getCenterX(),
                        startPort.getCenterY()
                )
        );

        moveTo.setX(p.getX());
        moveTo.setY(p.getY());
    }

    private void updateEnd() {
        if (endPort == null || getParent() == null) return;

        Point2D p = getParent().sceneToLocal(
                endPort.localToScene(
                        endPort.getCenterX(),
                        endPort.getCenterY()
                )
        );

        lineTo.setX(p.getX());
        lineTo.setY(p.getY());
    }

    public void updatePreview(Point2D scenePoint) {
        if (getParent() == null) return;

        Point2D p = getParent().sceneToLocal(scenePoint);
        lineTo.setX(p.getX());
        lineTo.setY(p.getY());
    }

}

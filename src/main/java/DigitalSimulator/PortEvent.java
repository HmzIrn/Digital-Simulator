package DigitalSimulator;

import javafx.event.Event;
import javafx.event.EventType;

public class PortEvent extends Event {
    public static final EventType<PortEvent> PORT_CLICKED = new EventType<>(ANY, "PORT_CLICKED");

    public final PortNode port;

    public PortEvent(PortNode port) {
        super(PORT_CLICKED);
        this.port = port;
    }
}

package DigitalSimulator;

public enum GateType {
    AND("M-10 10 L0 10 M-10 30 L0 30 M50 20 L70 20 M0 0 L30 0 A20 20 0 0 1 30 40 L0 40 Z"),
    OR("M-10 10 L5 10 M-10 30 L5 30 M45 20 L70 20 M0 0 Q20 20 0 40 Q25 40 45 20 Q25 0 0 0 Z"),
    NAND("M-10 10 L0 10 M-10 30 L0 30 M60 20 L70 20 M0 0 L30 0 A20 20 0 0 1 30 40 L0 40 Z M59 20 A4 4 0 1 1 51 20 A4 4 0 1 1 59 20"),
    NOR("M-10 10 L5 10 M-10 30 L5 30 M53 20 L70 20 M0 0 Q20 20 0 40 Q25 40 45 20 Q25 0 0 0 Z M53 20 A4 4 0 1 1 45 20 A4 4 0 1 1 53 20");

    private final String svgPath;

    GateType(String svg) {
        this.svgPath = svg;
    }

    public String getSvgPath(){
        return svgPath;
    }
}

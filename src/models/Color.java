package models;

public enum Color {

    AMARILLO('A'),
    ROJO('R'),
    VERDE('V'),
    AZUL('Z'),
    BLANCO('B'),
    NEGRO('N');

    private char value;

    private Color(char value) {
        this.value = value;
    }

    public String toString() {
        return "" + value;
    }
}

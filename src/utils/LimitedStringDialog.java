package utils;

import models.SecretKey;

import java.util.regex.Pattern;

public class LimitedStringDialog {

    private String title;
    private int size;

    public LimitedStringDialog(String title, int size) {
        assert title != null;
        assert size != 0;
        this.title = title;
        this.size = size;
    }

    public String read() {
        IO io = new IO();
        //Exp. regular que comprueba si el código lo forman 4 letras de los colores
        String regExp = "[ARVZNB]{4}";
        String attemp;
        do {
            attemp = io.readString(title).toUpperCase();
            if ((attemp.length() != this.size) || (!Pattern.matches(regExp, attemp))) {
                io.writeln("La cadena debe tener  " + this.size + " caracteres [A, R, V, Z, B, N]");
            }
        } while ((attemp.length() != this.size) || (!Pattern.matches(regExp, attemp)));

        return attemp;
    }
}


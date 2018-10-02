package models;

import utils.LimitedStringDialog;

import java.util.Random;

public class SecretKey {

    private char[] secret;
    public static final int NUM_TOKENS = 4;
    private String value;


    public void read(String title) {
        assert title != null;
        this.secret = new LimitedStringDialog(title, SecretKey.NUM_TOKENS).read().toUpperCase().toCharArray();
    }

    public void generateRandomKey() {
        secret = new char[NUM_TOKENS];
        Color[] color = Color.values();
        Random random = new Random();
        String aux = "";
        for (int i = 0; i < NUM_TOKENS; i++) {
            secret[i] = color[random.nextInt(color.length)].toString().charAt(0);
            aux += color[random.nextInt(color.length)];
        }
        this.value = aux;
    }

    public char[] getSecretKey() {
        return this.secret;
    }
}

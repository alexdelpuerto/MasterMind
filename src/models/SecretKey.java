package models;

import java.util.Random;

public class SecretKey {

    private char[] secret;
    public static final int NUM_TOKENS = 4;

    public void generateRandomKey() {
        secret = new char[NUM_TOKENS];
        Color[] color = Color.values();
        Random random = new Random();
        for (int i = 0; i < NUM_TOKENS; i++) {
            secret[i] = color[random.nextInt(color.length)].toString().charAt(0);
        }
    }

    public char[] getSecretKey() {
        return this.secret;
    }

    public void setSecretKey(char[] secret) {
        assert secret.length == SecretKey.NUM_TOKENS;
        this.secret = secret;
    }
}

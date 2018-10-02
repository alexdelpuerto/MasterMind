package views;

import models.SecretKey;
import utils.IO;
import utils.LimitedStringDialog;

import static java.lang.String.valueOf;

public class SecretKeyView {
    private String title;
    private SecretKey secretKey;

    SecretKeyView(String title, SecretKey secretKey) {
        assert title != null;
        assert secretKey != null;
        this.title = title;
        this.secretKey = secretKey;
    }

    void read() {
        secretKey.setSecretKey(new LimitedStringDialog(title, SecretKey.NUM_TOKENS).read().toUpperCase().toCharArray());
    }

    public void write() {
        new IO().writeln(title + " " + valueOf(this.secretKey));
    }
}

package controllers;

import models.Game;
import models.SecretKey;
import utils.IO;

import static java.lang.String.valueOf;

public class RandomGuessController extends GuessController {

    public RandomGuessController(Game game) {
        super(game);
    }

    protected SecretKey readUserCode(String title) {
        SecretKey userCode = new SecretKey();
        userCode.generateRandomKey();
        new IO().writeln("Nº" + (this.countAttemps() + 1) + "-" + title + " " + valueOf(userCode.getSecretKey()));
        return userCode;
    }
}

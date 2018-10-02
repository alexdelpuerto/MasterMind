package controllers;

import models.Game;
import models.SecretKey;
import utils.IO;

public class ManualGuessController extends GuessController {

    public ManualGuessController(Game game) {
        super(game);
    }

    protected SecretKey readUserCode(String title) {
        SecretKey userCode = new SecretKey();
        new IO().write("Nº" + (this.countAttemps() + 1) + "-");
        userCode.read(title);
        return userCode;
    }
}

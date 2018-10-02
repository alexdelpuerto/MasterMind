package controllers;

import models.Game;
import models.SecretKey;
import models.State;
import utils.IO;

import java.util.regex.Pattern;

public abstract class GuessController extends OperationController {

    public static final int NUM_ATTEMPS = 10;
    private SecretKey userCode;

    protected GuessController(Game game) {
        super(game);
        assert game != null;
    }

    public void control() {
        assert this.getState() == State.IN_GAME;
        userCode = this.readUserCode("Intento:[cuatro letras de entre A-amarillo, R-rojo, V-verde, Z-azul, B-blanco, N-negro]");
        this.guess(userCode);

        if (this.existVictory()) {
            this.setState(State.FINAL);
            this.win();
        } else {
            this.writeInjuredAndDead();
            if (this.countAttemps() == GuessController.NUM_ATTEMPS) {
                this.setState(State.FINAL);
            }
        }
    }

    public void win() {
        new IO().writeln(SecretKey.NUM_TOKENS + " muertos!!! Victoria");
    }

    protected abstract SecretKey readUserCode(String title);
}

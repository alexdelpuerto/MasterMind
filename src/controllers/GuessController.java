package controllers;

import models.Game;
import models.SecretKey;
import models.State;

public abstract class GuessController extends OperationController {

    public static final int NUM_ATTEMPS = 10;

    protected GuessController(Game game) {
        super(game);
    }

    public void control(SecretKey userCode) {
        assert this.getState() == State.IN_GAME;
        this.guess(userCode);

        if (this.existVictory()) {
            this.setState(State.FINAL);
        } else {
            if (this.countAttemps() == GuessController.NUM_ATTEMPS) {
                this.setState(State.FINAL);
            }
        }
    }

    public abstract SecretKey readUserCode(String title);

    public GuessController getGuessController() {
        return this;
    }
}

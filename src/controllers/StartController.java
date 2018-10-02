package controllers;

import models.Game;
import models.State;
import utils.LimitedIntDialog;

public class StartController extends OperationController {

    private GuessController guessController;

    protected StartController(Game game) {
        super(game);
    }

    public void control() {
        assert this.getState() == State.INITIAL;

        int selection = new LimitedIntDialog("1.Partida\n2.Demo\nOpción?:", 1, 2).read();

        if (selection == 1) {
            guessController = new ManualGuessController(this.getGame());
        } else {
            guessController = new RandomGuessController(this.getGame());
        }
        this.generateSecret();
        this.setState(State.IN_GAME);
    }

    public GuessController getGuessController() {
        return guessController;
    }
}


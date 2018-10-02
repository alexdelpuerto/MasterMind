package controllers;

import models.Game;
import models.State;

public class StartController extends OperationController {

    private GuessController guessController;

    protected StartController(Game game) {
        super(game);
    }

    public void start(int selection) {
        assert this.getState() == State.INITIAL;

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

    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
}


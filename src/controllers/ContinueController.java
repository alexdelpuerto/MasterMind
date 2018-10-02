package controllers;

import models.Game;
import models.State;

public class ContinueController extends OperationController {

    protected ContinueController(Game game) {
        super(game);
    }

    public void resume(boolean again) {
        assert this.getState() == State.FINAL;

        if (again) {
            this.clear();
            this.setState(State.INITIAL);
        } else {
            this.setState(State.EXIT);
        }
    }

    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
}
package controllers;

import models.Game;

public abstract class OperationController extends Controller {

    protected OperationController(Game game) {
        super(game);
    }

    @Override
    public abstract void control();
}

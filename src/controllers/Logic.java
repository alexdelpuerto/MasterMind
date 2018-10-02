package controllers;

import models.Game;

public class Logic {

    private Game game;
    private StartController startController;
    private ContinueController continueController;

    public Logic() {
        game = new Game();
        startController = new StartController(game);
        continueController = new ContinueController(game);
    }

    public OperationController getController() {
        switch (game.getState()) {
            case INITIAL:
                return startController;
            case IN_GAME:
                return startController.getGuessController();
            case FINAL:
                return continueController;
            case EXIT:
            default:
                return null;
        }
    }
}
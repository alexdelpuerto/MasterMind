package controllers;

import models.Game;
import models.SecretKey;

public class ManualGuessController extends GuessController {

    public ManualGuessController(Game game) {
        super(game);
    }

    @Override
    public SecretKey readUserCode(String title) {
        SecretKey userCode = new SecretKey();
        return userCode;
    }

    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
}

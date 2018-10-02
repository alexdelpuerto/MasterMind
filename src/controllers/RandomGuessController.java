package controllers;

import models.Game;
import models.SecretKey;

public class RandomGuessController extends GuessController {

    public RandomGuessController(Game game) {
        super(game);
    }

    public SecretKey readUserCode(String title) {
        SecretKey userCode = new SecretKey();
        userCode.generateRandomKey();
        return userCode;
    }

    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
}

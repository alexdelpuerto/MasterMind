package controllers;

import models.Game;
import models.State;
import utils.IO;

public class ContinueController extends OperationController {

    protected ContinueController(Game game) {
        super(game);
    }

    @Override
    public void control() {
        assert this.getState() == State.FINAL;
        char again;

        do {
            again = new IO().readChar("Volver a jugar? (s/n): ");
            again = Character.toUpperCase(again);
        } while (again != 'S' && again != 'N');

        if (again == 'S') {
            this.clear();
            this.setState(State.INITIAL);
        } else {
            this.setState(State.EXIT);
        }
    }
}
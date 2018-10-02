package controllers;

import models.Game;
import models.SecretKey;
import models.State;

public abstract class Controller {

    private Game game;

    protected Controller(Game game) {
        assert game != null;
        this.game = game;
    }

    public State getState() {
        return game.getState();
    }

    public void setState(State state) {
        assert state != null;
        game.setState(state);
    }

    protected Game getGame() {
        return this.game;
    }

    public boolean existVictory() {
        return game.existVictory();
    }

    protected void guess(SecretKey secretKey) {
        game.guess(secretKey);
    }

    public int countAttemps() {
        return game.countAttemps();
    }

    protected void generateSecret() {
        game.generateSecret();
    }

    protected void clear() {
        game.clear();
    }

    public int deadNumber() {
        return game.deadNumber();
    }

    public int injuredNumber() {
        return game.injuredNumber();
    }
}
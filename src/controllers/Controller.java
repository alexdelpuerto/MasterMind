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

    public abstract void control();

    protected State getState() {
        return game.getState();
    }

    protected void setState(State state) {
        assert state != null;
        game.setState(state);
    }

    protected Game getGame() {
        return this.game;
    }

    protected boolean existVictory() {
        return game.existVictory();
    }

    protected void guess(SecretKey secretKey) {
        game.guess(secretKey);
    }

    protected void writeInjuredAndDead() {
        game.writeInjuredAndDead();
    }

    protected int countAttemps() {
        return game.countAttemps();
    }

    protected void generateSecret() {
        game.generateSecret();
    }

    protected void clear() {
        game.clear();
    }
}
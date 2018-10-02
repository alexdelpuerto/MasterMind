package models;

public class Game {

    private State state;
    private Board board;

    public Game() {
        state = State.INITIAL;
        this.board = new Board();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public boolean existVictory() {
        return board.existVictory();
    }

    public void guess(SecretKey secretKey) {
        board.guess(secretKey);
    }

    public int countAttemps() {
        return board.countAttemps();
    }

    public void generateSecret() {
        board.generateSecret();
    }

    public void clear() {
        board.clear();
    }

    public int deadNumber() {
        return board.deadNumber();
    }

    public int injuredNumber() {
        return board.injuredNumber();
    }
}

package views;

import controllers.*;
import models.SecretKey;
import models.State;
import utils.IO;
import utils.LimitedIntDialog;
import utils.YesNoDialog;

public class MasterMindView implements OperationControllerVisitor {
    private IO io = new IO();

    public void interact(OperationController controller) {
        assert controller != null;
        controller.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        int selection = new LimitedIntDialog("1.Partida\n2.Demo\nOpción?:", 1, 2).read();
        startController.start(selection);
        new BoardView(startController).writeSecret();
    }

    @Override
    public void visit(GuessController guessController) {
        assert guessController.getGuessController().getState() == State.IN_GAME;
        SecretKey userCode;
        new IO().write("Nº" + (guessController.countAttemps() + 1) + "-");
        this.readUserCode("Intento: [cuatro letras de entre A-amarillo, R-rojo, V-verde, Z-azul, B-blanco, N-negro]", guessController.getGuessController());

        if (guessController.getGuessController().existVictory()) {
            guessController.getGuessController().setState(State.FINAL);
        } else {
            new BoardView(guessController.getGuessController()).writeInjuredAndDead();
            if (guessController.getGuessController().countAttemps() == GuessController.NUM_ATTEMPS) {
                guessController.getGuessController().setState(State.FINAL);
            }
        }
    }

    @Override
    public void visit(ContinueController continueController) {
        continueController.resume(new YesNoDialog("Desea continuar").read());
    }

    private SecretKey readUserCode(String title, GuessController guessController) {
        SecretKey userCode = guessController.getGuessController().readUserCode(title);
        new SecretKeyView(title, userCode).read();
        new SecretKeyView("Secret: ", userCode).write();
        return userCode;
    }

    public void win() {
        new IO().writeln(SecretKey.NUM_TOKENS + " muertos!!! Victoria");
    }
}

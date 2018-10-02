package views;

import controllers.OperationController;
import models.SecretKey;
import utils.IO;

public class BoardView {

    private OperationController controller;

    BoardView(OperationController controller) {
        assert controller != null;
        this.controller = controller;
    }

    public void writeInjuredAndDead() {
        IO io = new IO();
        io.writeln(controller.deadNumber() + " muertos y " + (controller.injuredNumber() - controller.deadNumber()) + " heridos ");
    }

    public void writeSecret() {
        IO io = new IO();
        io.write("Secreto: ");
        for (int i = 0; i < SecretKey.NUM_TOKENS; i++) {
            io.write("*");
        }
        io.writeln();
    }
}

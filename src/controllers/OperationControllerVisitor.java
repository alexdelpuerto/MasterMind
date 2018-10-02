package controllers;

public interface OperationControllerVisitor {

    void visit(StartController startController);

    void visit(GuessController guessController);

    void visit(ContinueController continueController);
}

package hw20200618_FP.action;

public class ActionRun implements Action {
    String action = "Run!";

    @Override
    public void doAction() {
        System.out.println("Hello, " + action);
    }
}

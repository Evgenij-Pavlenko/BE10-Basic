package hw20200618_FP.action;

public class ActionSit implements Action {
    String action = "Sit!";

    @Override
    public void doAction() {
        System.out.println("Hello, " + action);
    }
}

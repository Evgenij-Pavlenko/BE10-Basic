package hw20200618_FP.action;

public class ActionSleep implements Action {
    String action = "Sleep!";

    @Override
    public void doAction() {
        System.out.println("Hello, " + action);
    }
}

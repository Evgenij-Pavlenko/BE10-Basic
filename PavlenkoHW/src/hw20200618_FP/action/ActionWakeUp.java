package hw20200618_FP.action;

public class ActionWakeUp implements Action {
    String action = "Wake up, Neo!";

    @Override
    public void doAction() {
        System.out.println("Hello, " + action);
    }
}

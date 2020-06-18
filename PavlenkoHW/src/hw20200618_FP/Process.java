package hw20200618_FP;

import hw20200618_FP.action.Action;

public class Process {
    private String action;
    private FactoryAction factoryAction;

    public Process(String action, FactoryAction factoryAction) {
        this.action = action;
        this.factoryAction = factoryAction;
    }

    public void make() {
        Action act = factoryAction.getAction(action);
        if (act != null) {
            act.doAction();
        } else {
            System.out.println(action + " - not found");
        }

    }

}

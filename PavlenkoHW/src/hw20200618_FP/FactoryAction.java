package hw20200618_FP;

import hw20200618_FP.action.*;

public class FactoryAction {
    Action action;

    public Action getAction(String action) {
        switch (action) {
            case "run":
                return new ActionRun();
            case "sit":
                return new ActionSit();
            case "sleep":
                return new ActionSleep();
            case "wake up":
                return new ActionWakeUp();
            default:
                return null;
        }

    }
}

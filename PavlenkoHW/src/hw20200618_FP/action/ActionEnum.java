package hw20200618_FP.action;

public enum ActionEnum {
    RUN("Run"),
    SIT("Sit"),
    SLEEP("Sleep"),
    WAKEUP("Wakeup");
    // need think....
    private final String str;

    ActionEnum(String str) {
        this.str = str;
    }
}

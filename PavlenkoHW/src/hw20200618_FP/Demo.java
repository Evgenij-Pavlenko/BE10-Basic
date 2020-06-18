package hw20200618_FP;

import java.util.List;

import static hw20200618_FP.ActionFromFile.getActionFromFile;

public class Demo {

    public static void main(String[] args) {
        List<String> actionList = getActionFromFile(args[0]);
        FactoryAction factoryAction = new FactoryAction();

        for (String action : actionList) {
            Process process = new Process(action, factoryAction);
            process.make();
        }
    }
}

package de.telran.factory;

import de.telran.action.*;
import de.telran.service.ActionsConfigService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageActionFactory {
   private ActionsConfigService configService;
    private Map<String, ImageAction> imageActionsMap = new HashMap<>();

    public ImageActionFactory(ActionsConfigService configService) throws Exception {
        this.configService = configService;

        List<String> actionClassNames = configService.getActionClassNames();
        String packageName = configService.getActionPackage();
        for (String className : actionClassNames) {
            ImageAction imageAction = (ImageAction) Class.forName(packageName + "." + className).getConstructor().newInstance();
            imageActionsMap.put(imageAction.getName(), imageAction);

        }

    }

    public ImageAction getImageAction(String actionName) {
        ImageAction imageAction = imageActionsMap.get(actionName);
        if (imageAction == null) {
            return new DefaultImageAction();
        } else {
            return imageAction;
        }
    }
}

package de.telran.action;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PreviewImageAction implements ImageAction {

    @Override
    public String getName() {
        return "PREVIEW";
    }

    @Override
    public BufferedImage doAction(BufferedImage source) {
        System.out.println("Creating a preview");
        return doResizedPreview(source);
    }

    private BufferedImage doResizedPreview(BufferedImage source) {
        int width = 250;
        int height = 250;
        System.out.println("resizing...");
        int type = source.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : source.getType();
        BufferedImage scaledBI = new BufferedImage(width, height, type);
        Graphics2D g = scaledBI.createGraphics();
        g.drawImage(source, 0, 0, width, height, null);
        g.dispose();
        return scaledBI;
    }
}

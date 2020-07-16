package de.telran.entity;

import java.awt.image.BufferedImage;
import java.util.Objects;

public class ActionableImage {
    private BufferedImage image;
    private boolean isSuccessfull;
    private String sourceUrl;
    private String actionName;

    public ActionableImage(BufferedImage image, boolean status, String sourceUrl, String actionName) {
        this.image = image;
        this.isSuccessfull = status;
        this.sourceUrl = sourceUrl;
        this.actionName = actionName;

    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean isSuccessfull() {
        return isSuccessfull;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public String getActionName() {
        return actionName;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setSuccessfull(boolean successfull) {
        isSuccessfull = successfull;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionableImage that = (ActionableImage) o;
        return isSuccessfull == that.isSuccessfull &&
                Objects.equals(image, that.image) &&
                Objects.equals(sourceUrl, that.sourceUrl) &&
                Objects.equals(actionName, that.actionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, isSuccessfull, sourceUrl, actionName);
    }

    @Override
    public String toString() {
        return "ActionableImage{" +
                "image=" + image +
                ", isSuccessfull=" + isSuccessfull +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", actionName='" + actionName + '\'' +
                '}';
    }
}

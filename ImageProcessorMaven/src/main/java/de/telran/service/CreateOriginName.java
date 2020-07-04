package de.telran.service;

public class CreateOriginName {
    public static String createOriginNameFromUrl(String urlName){
        int indexFirst =urlName.lastIndexOf('/')+1;
        int indexLast = urlName.lastIndexOf('.');
        String imageName = urlName.substring(indexFirst,indexLast);
        System.out.println(imageName);
        return imageName;
    }
}

package hw20200618_FP;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ActionFromFile {

    public static List<String> getActionFromFile(String file) {

        try {
            return Files.lines(Paths.get(file)).collect(Collectors.toList());
        } catch (ArrayIndexOutOfBoundsException | IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        return null;
    }
}

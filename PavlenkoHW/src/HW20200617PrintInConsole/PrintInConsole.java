package HW20200617PrintInConsole;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class PrintInConsole {
    public static void main(String[] args) throws IOException {
        /*
        через ide(с установкой параметров) - работает нормально

        через консоль:
        javac PrintInConsole.java (прямо в папке с файлом)
        java PrintInConsole people.csv -выдает ошибку:
        Error: Could not find or load main class PrintInConsole

        *PATH к JDK прописан в системе
            stackoverflow - читал - там в основном про путь к JDK,
            правильность пути к java файлу,
            правильность слешей
        Буду ждать урока, чтобы прояснить

         */
        String s = args[0];
        System.out.println(s);
        Stream<String> lines = Files.lines(Paths.get(args[0]));
        lines.forEach(System.out::println);

        /*
        Получение изображения с инета по url и сохранение его, как объекта
         */
        Image image;
        URL url = new URL("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
        image = ImageIO.read(url);
        /*
        сохраниене на диск в папку проекта
         */
        ImageIO.write((RenderedImage) image, "jpg", new File("out.jpg"));
    }
}

package HW20200704IO;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamIO2 {
    public static void main(String[] args) {


        String fileFrom = "C:/temp/temp/bigfile.zip";
        String fileTo = "C:/temp/temp2/bigfile.zip";
        StreamIO2 sio2 = new StreamIO2();
//        sio2.copyFileByte(fileFrom, fileTo);
//        sio2.copyFileBuffer(fileFrom, fileTo);
        sio2.copyFileAvailable(fileFrom, fileTo);

    }

    // All right
    public void copyFileByte(String from, String to) {
        int a = 0;
        try {
            InputStream inputStream = new FileInputStream(from);
            File file = new File(to);
            File dir = new File(file.getParent());

            //Есть какойто способ проще создать сразу файл в папках, если пути еще нет?
            //Create the file
            if (dir.mkdirs() && file.createNewFile()) {

                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }

            OutputStream outputStream = new FileOutputStream(to);

            while ((a = inputStream.read()) != -1) {
                outputStream.write(a);
            }
            System.out.println("File " + file.getName() + " has copied");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFileBuffer(String from, String to) {
        int a = 0;
        try {
            InputStream inputStream = new FileInputStream(from);
            File file = new File(to);
            File dir = new File(file.getParent());

            //Create the file
            if (dir.mkdirs() && file.createNewFile()) {

                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }
            OutputStream outputStream = new FileOutputStream(to);
            System.out.println("byte avalable: " + inputStream.available());
            byte[] buf = new byte[6];
            while ((a = inputStream.read(buf)) != -1) {
                //добавляет лишние 3  символа в конец строки последней
                outputStream.write(buf);
                System.out.println("File length: " + file.length());
                System.out.println("byte read: " + a);
                System.out.println("byte avalable: " + inputStream.available());
                // иначе добавляет лишние символы в конец строки последней
                //видимо, берет их с предыдущего прохода массива
                // buf = null; -> NullPointerException
                //или byte[] buf = new byte[6]; - переместить в цикл, но так каждый раз создается новый массив
                Arrays.fill(buf, (byte) 0);

            }
            System.out.println("File " + file.getName() + " has copied");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFileAvailable(String from, String to) {
        int a = 0;
        try {
            InputStream inputStream = new FileInputStream(from);
            File file = new File(to);
            File dir = new File(file.getParent());

            //Create the file
            if (dir.mkdirs() && file.createNewFile()) {

                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }
            OutputStream outputStream = new FileOutputStream(to);
            System.out.println("byte avalable: " + inputStream.available());
            while ((a = inputStream.read()) != 0) {
                byte[] buf = new byte[a]; //NegativeArraySizeException ((
                outputStream.write(buf);
                System.out.println("byte read: " + a);
                System.out.println("byte avalable: " + inputStream.read(buf));


            }
            System.out.println("File " + file.getName() + " has copied");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static File totalAmountPerPerson(String file) {
        File outFile = new File("totalAmountPerPerson.txt");
        String str = null;
        String[] person = null;
        List<Person2> listPerson2 = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((str = br.readLine()) != null) {
                person = str.split(",");
                listPerson2.add(new Person2(person[0], person[1], Integer.parseInt(person[3])));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        // все, надо еще думать...
        //List<Person2> outList = listPerson2.stream().map(p->p.getLastName()).collect(Collectors.toList());
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFile))) {
            for (Person2 c : listPerson2) {
                bw.write(c.getFirstName() + " " + c.getLastName()
                        + "," + c.getSum() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (!outFile.isEmpty()) {
            System.out.println("File created");
        }
        return outFile;
    }

}

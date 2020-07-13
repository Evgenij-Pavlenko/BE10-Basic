package HW20200704IO;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class StreamIO2 {
    public static void main(String[] args) {


        String fileFrom = "C:/temp/temp/bigfile.zip";
        String fileTo = "C:/temp/temp2/bigfile.zip";
        StreamIO2 sio2 = new StreamIO2();
//        sio2.copyFileByte(fileFrom, fileTo);
//        sio2.copyFileBuffer(fileFrom, fileTo);
//        sio2.copyFileAvailable(fileFrom, fileTo);
        System.out.println("-----------TotalAmountList--------------");
        String file2 = "persons2";
        totalAmountPerPerson(file2);
        System.out.println("---------PersonDate----------");
        String file3 = "person3.csv";
        sortedDateForPerson(file3);

    }
/*
Написать функцию
public void copyFile(String from, String to){}
которая принимает файл и цель и копирует файл. Например,
copyFile(“c:\\temp\\bigfile.zip”, “c:\\temp2”)
должна скопировать bigfile.zip в папку temp2 .
Возможны 3 реализации: вычитывание файла побайтово, вычитывание блоками в
буфер заданного размера или вычитывание того, что доступно для вычитывания с
использованием функции available().
 */

    // вычитывание файла побайтово
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

    // вычитывание блоками в буфер заданного размера
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
//            System.out.println("byte avalable: " + inputStream.available());
            byte[] buf = new byte[6];
            while ((a = inputStream.read(buf)) != -1) {
                //добавляет лишние 3  символа в конец строки последней
                outputStream.write(buf);
//                System.out.println("File length: " + file.length());
//                System.out.println("byte read: " + a);
//                System.out.println("byte avalable: " + inputStream.available());
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

    //вычитывание того, что доступно для вычитывания с использованием функции available()
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
            while ((a = inputStream.available()) != 0) {
                byte[] buf = new byte[a];
                // при просмотре файла - только точки. Зазмер файла одинаковый
                outputStream.write(buf);
                int readByte = inputStream.read(buf);
                System.out.println("byte available: " + a);
                System.out.println("byte read: " + readByte);
            }
            System.out.println("File " + file.getName() + " has copied");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/*
Задача 2
Есть файл:
Sergey,Lukichev,Notebook Lenovo,500
Piotr,Ivanov,Apple MacBook,800
Sergey,Lukichev,Keyboard Cherry,25
Ivan,Petrov,Mouspad,5
Piotr,Ivanov,Apple Touchpad,60
То есть список имен с оборудованием и оценочной стоимостью. Имена могут
повторяться. Нужно написать программу, которая вернет файл с отсортированным по
сумме списком имен и суммой по стоимости для каждого человека:
Ivan Petrov,5
Sergey Lukichev,525
Piotr Ivanov,860
 */

    public static File totalAmountPerPerson(String file) {
        File outFile = new File("totalAmountPerPerson.txt");
        System.out.println(outFile);
        String str;
        String[] person;
        List<Person2> listPerson2 = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            while ((str = in.readLine()) != null) {
                person = str.split(",");
                //тут данные в Person2 я бы сразу объединил имя и фамилию
                listPerson2.add(new Person2(person[0], person[1], Integer.parseInt(person[3])));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Set<Person2> person2Set = new HashSet<>();


//        listPerson2.stream().flatMap(p -> p.getLastName()).;
        // все, надо еще думать...
        // пройтись по каждому персонажу - посчитать общую сумму, потом отсортировать - это уже O(n в кубе)
        Map<String, List<Person2>> collect = listPerson2.stream()
                .collect(Collectors.groupingBy(Person2::getFirstName));

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFile))) {
//            for (Map.Entry e : collect.entrySet()) {
//                bw.write(e + "\n");
//            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (outFile.length() > 0) {
            System.out.println("File created");
        }
        return outFile;
    }

    /* *Работает*
    Задача 3
Есть файл со списком имен с датами рождения:
Sergey,15-02-1979
Ivan,22-03-1986
Piotr,01-10-1955
Anna,13-12-1995
Нужно написать программу, которая возвращает файл со списком имен и дат
рождений, отсортированный по дате рождения.

Дополнительное задание : те строки в файле, для которых дата рождения указана в
другом формате, записать в отдельный файл без изменений.
     */

    public static void sortedDateForPerson(String file) {
        File outFile = new File("PersonWithDate.txt");
        File unstatdartDate = new File("PersonUnDate.txt");
        System.out.println(outFile);
        String str;
        String[] person;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        List<PersonDate> personDates = new ArrayList<>();
        List<String> personUnDates = new ArrayList<>();

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            while ((str = in.readLine()) != null) {
                try { // blank line protection
                    person = str.split(",");
                    if (isDate(person[1], formatter)) {
                        personDates.add(new PersonDate(person[0], LocalDate.parse(person[1], formatter)));
                    } else {
                        personUnDates.add(str);
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(personDates);


        List<String> persons = personDates.stream()
                .sorted(Comparator.comparing(PersonDate::getDate))
                .map(p -> p.getName() + "," + p.getDate()).collect(Collectors.toList());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
             BufferedWriter bwUnstandart = new BufferedWriter(new FileWriter(unstatdartDate))) {
            for (String p3 : persons) {
                bw.write(p3 + System.lineSeparator());
            }
            for (String s : personUnDates) {
                bwUnstandart.write(s + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (outFile.length() > 0) {
            System.out.println("File created");
        }
    }

    public static boolean isDate(String string, DateTimeFormatter formatter) {
        try {
            LocalDate.parse(string, formatter);
            return true;
        } catch (Exception e) {
            System.out.println("Date format: " + string + " not supported");
            return false;
        }

    }

}

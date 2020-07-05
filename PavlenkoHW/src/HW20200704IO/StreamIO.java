package HW20200704IO;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class StreamIO {
    public static void main(String[] args) throws Exception {
        System.out.println("--------Sum int in file----------");
        String file = "sum.txt";
        System.out.println(sumFromFile1(file));
        System.out.println(sumFromFile2(file));
        System.out.println("--------Sorted Array----------");
        String[] strArr = {"aaa", "bbbb", "a", "bb"};
        System.out.println(Arrays.toString(sortedStringArray(strArr)));
        System.out.println("-----------create sorted list Person from file-------------");
        String file2 = "persons.csv";
        readListPerson(file2);
        System.out.println("------Customers to file .csv--------");
        String file3 = "customers.csv";
        List<Customers> customers = new ArrayList<>();
        Collections.addAll(customers,
                new Customers("Vasja", "Vasjev", 18),
                new Customers("Petja", "Petrov", 20),
                new Customers("Ivan", "Ivanov", 53));
        customersToFile(customers, file3);

    }


    /*
1. Есть текстовый файл, где каждая строка - целое число:
1
2
5
45
54 => 107
Написать функцию, которая принимает имя файла, возвращает сумму чисел из файла.
Подсказка: FileReader, BufferedReader плюс stream API.
 */
    public static int sumFromFile1(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return br.lines().mapToInt(Integer::parseInt).sum();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int sumFromFile2(String file) {
        try {
            return Files.lines(Paths.get(file)).mapToInt(Integer::parseInt).sum();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }


    /*
    2. Есть массив строк разной длины. Отсортировать его по длине строк. Пример:
вход {“aaa”, “bbbb”, “a”, ‘bb”} , выход {“a”, “bbb”, “aaa”, “bbbb”} . Подсказка:
Stream API, sorted, Comparator, lambda functions, Java Doc.
     */

    public static String[] sortedStringArray(String[] input) {
        //Exception in thread "main" java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
//        Comparator<String> compByLength = (s1, s2) -> s1.length() - s2.length();
//        return (String[]) Arrays.stream(input)
//                .sorted(compByLength).toArray();
        //Exception in thread "main" java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
//        return (String[]) Arrays.stream(input)
//                .sorted(Comparator.comparing(String::length)).toArray();

        Arrays.sort(input, Comparator.comparing(String::length));
        return input;
    }


/*
3. Есть текстовый csv файл:
“Ivan”, “18”
“Piotr”, “20”
“Anna”, “10”
Вывести на экран отсортированный по возрасту список. Подсказка: вычитать файл
построчно с помощью Reader’a, положить данные в список классов Person, список
отсортировать с помощью Stream API.
Можно усложнить - вычитать только тех, кто старше 17 лет. Тут разные варианты
решения: вычитать всех, потом отсортировать тех, кто старше 17, но если список в
файле большой, то может не стоит создавать объекты в Джаве, то есть проверять в
процессе чтения и создавать Джава объекты только для тех пользователей, что
старше 17.
 */

    public static void readListPerson(String file) {
        String str = null;
        String[] person = null;
        List<Person3> listPerson3 = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((str = br.readLine()) != null) {
                person = str.replace("\"", "").split(",");
                listPerson3.add(new Person3(person[0], Integer.parseInt(person[1])));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("---------sorted List---------");
        listPerson3.stream().sorted((p1, p2) -> p1.getAge() - p2.getAge())
                .forEach(System.out::println);
        System.out.println("---------sorted List age>17---------");
        listPerson3.stream().filter(i -> i.getAge() > 17)
                .sorted((p1, p2) -> p1.getAge() - p2.getAge())
                .forEach(System.out::println);
    }


    /*
    4. Ну и обратная задачка: есть список Customers: firstName, lastName, age -
сохранить его в csv файл, похожий на то, что в 3.
     */

    public static void customersToFile(List<Customers> customers, String file3) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file3))) {
            for (Customers c : customers) {
                bw.write(c.getFirstName() + "," + c.getLastName()
                        + "," + c.getAge() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (!file3.isEmpty()) {
            System.out.println("File created");
        }
    }
}

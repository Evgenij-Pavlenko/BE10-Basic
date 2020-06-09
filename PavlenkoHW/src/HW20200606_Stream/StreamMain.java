package HW20200606_Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Person p1 = new Person("Vasja", 16, new Address("Potsdamer Str", 1));
        Person p2 = new Person("Petja", 18, new Address("Potsdamer Str", 2));
        Person p3 = new Person("Mike", 17, new Address("Potsdamer Str", 3));
        Person p4 = new Person("Bob", 25, new Address("Potsdamer Str", 4));
        List<Person> list = Arrays.asList(p1, p2, p3, p4);
        System.out.println(ageOver17(list));
        System.out.println(ibannStars("DE32 1234 1452 1254 12"));

        //11.
        printGeneralAgeOver17(list);

    }

    //просто выводит список адресов на печать. Зато в 1 строку))
    public static void ageOver17_1(List<Person> list) {
        list.stream().filter(s -> s.age >= 17).forEach(s -> System.out.println(s.address));

    }

    /*
   1. Нужно написать функцию, которая по списку persons вернет список адресов тех
    людей, чей возраст больше 17 лет.
     */
    //возвращает список адресов, но, думаю, есть решение в 1 строку...
    public static List<Address> ageOver17(List<Person> list) {
        List<Address> adr = new ArrayList<>();
        list.stream().filter(s -> s.age >= 17).forEach(s -> adr.add(s.address));
        return adr;
    }

    /*
    2. Есть список имен, нужно написать функцию, которая вернет список имен без
дупликатов.
     */
    public static List<String> namesUnduplikate(List<String> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    /*
    3. Есть список людей, нужно написать функцию, которая вернет мапу, где
ключом является возраст, а значением список людей этого возраста.
     */
    public static Map<Integer, List<Person>> getMapAge(List<Person> list) {
        return list.stream().collect(Collectors.groupingBy(p -> p.age));
    }

    /*
    4. Есть 2 класса..., нужно написать функцию, которая возвращает мапу, где значением является Person, а
значением - список его банковских счетов.
     */

    public static Map<Person4, List<BankAccount>> getBankAccountForPerson(List<BankAccount> list) {
        return list.stream().collect(Collectors.groupingBy(b -> b.getOwner()));
    }

    /*
    5. Написать функцию, которая для списка счетов, возвращает список IBANNs,
где в каждом IBANN символы после 3-го и до конца заменены звездочками.
     */
    public static List<String> getIBANNStarList(List<BankAccount> list) {
        //как-то с регулярными выражениями??
        //или вытянуть IBANN  как массив символов?..
        ////// блин, оказалось через 2 substring - подсмотрел на предыдущем курсе (
        // поскольку звездочки используются в нескольких задачах - получился отдельный метод ibannStars()
        List<String> ret = list.stream().filter(b -> b.getIBANN() != null)
                .map(BankAccount::getIBANN)//map(b->b.getIBANN()) - сначала так делал
                .map(StreamMain::ibannStars)
                .collect(Collectors.toList());
        return ret;
    }

    /*
    6. Написать функцию, которая принимает предложение, а возвращает
количество слов, начинающихся на заданную букву.
     */

    public static int wordCount(String s, String ch) {
        String[] sArray = s.split(" ");
        return (int) Arrays.stream(sArray).filter(f -> f.startsWith(ch)).count();
    }

    /*
    7. Написать функцию, которая проверяет, является ли заданная строка целым
числом. Подсказка - Character.isDigit() и Stream.allMatch().
     */
// This was very hard
    public static Boolean isInteger(String s) {
        return s.chars().allMatch(Character::isDigit);
    }

    /*
    8. Есть два класса:
public class BankAccount {
String IBANN;
}
public class Person {
String name;
List<String> banAccounts;
}
9. Написать функцию, которая по списку persons возвращает список их
банковских счетов с звездочками с третьего символа. Подсказка - flatMap()
     */

//    /**
//     * ПРОДОЛЖИТЬ!
//     *
//     */
//    public static List<String> getIBANNByPerson(List<Person8> listP) {
//        return listP.stream().flatMap(p -> p.getBanAccounts().stream())
//                .collect(Collectors.toList()).stream().map(StreamMain::ibannStars).collect(Collectors.toList());
//    }

    public static String ibannStars(String s) {
        // или звездочки должны не трогать пробелы???
        return s.substring(0, 3) + s.substring(3).replaceAll("\\w|\\s", "*");
    }

    /*
    10. Для списка persons посчитать общий возраст тех, кому больше 17 лет.
Подсказка - reduce()
     */

    public static int generalAgeOver17(List<Person> list) {
        return list.stream().filter(p -> p.getAge() >= 17).map(Person::getAge).reduce((a, b) -> a + b).orElse(0);
    }


    /*
    11. Написать функцию, которая для списка persons напечатает для тех, кто
старше 17 лет: In Germany <name1> and <name2> and …<nameN> are of legal
age. Подсказка - Collectors.joining();
     */
    //Тут без теста
    public static void printGeneralAgeOver17(List<Person> list) {
      String ret =   list.stream()
                .filter(p -> p.getAge() >= 17)
                .map(Person::getName)
                .collect(Collectors.joining(" and "));
        System.out.println("In Germany "+ ret+ " are of legal age.");
    }
}

class BankAccount8 {
    private String IBANN;

    public BankAccount8(String IBANN) {
        this.IBANN = IBANN;
    }

    public String getIBANN() {
        return IBANN;
    }
}

class Person8 {
    private String name;
    private List<String> banAccounts;

    public Person8(String name, List<String> banAccounts) {
        this.name = name;
        this.banAccounts = banAccounts;
    }

    public String getName() {
        return name;
    }

    public List<String> getBanAccounts() {
        return banAccounts;
    }

}


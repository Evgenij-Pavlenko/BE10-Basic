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
        return list.stream().collect(Collectors.groupingBy(b -> b.owner));
    }

    /*
    5. Написать функцию, которая для списка счетов, возвращает список IBANNs,
где в каждом IBANN символы после 3-го и до конца заменены звездочками.
     */
/////??????????????????????????????????
//    public static List<String> getIBANNStarList(List<BankAccount> list) {
//        //как-то с регулярными выражениями??
//        //или вытянуть IBANN  как массив символов?..
////        List<String> ret = list.stream().filter(b->b.IBANN!=null).map(b -> b.IBANN.replaceAll( "![a-z,A-Z,0-9]{3}","*")).collect(Collectors.toList());
////        return ret;
//        List<String> ret = new ArrayList<>();
//        Stream<Object> ch = list.stream().map(b -> b.IBANN);
//        ret = Arrays.stream(ch).skip(3).map(c -> c = '*').map(m->m.toString()).collect(Collectors.toList());
////        ret = ch.stream().map(m -> m.toString()).collect(Collectors.toList());
//        return ret;
//    }

    /*
    6. Написать функцию, которая принимает предложение, а возвращает
количество слов, начинающихся на заданную букву.
     */

    public static int wordCount(String s, String ch){
        String[] sArray = s.split(" ");
        return (int) Arrays.stream(sArray).filter(f->f.startsWith(ch)).count();
    }

}


package HW11052020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparatorDemo {
    public static void main(String[] args) {

        Person ivan = new Person("Ivan", "Ivanov", 60);
        Person piotr = new Person("Piotr", "Vasechkin", 40);
        Person anna = new Person("Anna", "Karenina", 50);

        List<Person> people = Arrays.asList(ivan, piotr, anna);
        List<Person> peopleSortetByFirstName = new ArrayList<>(people);

        System.out.println("-------------Unsortered People---------------------");
        System.out.println(people);

        // Встроеная сортировка по FirstName
        System.out.println("---------ComparePersonByFirstName----------");
        System.out.println(sortByFirstName(people));
//        Person p1>Person p2 =>p1.age > p2.age

        System.out.println("---------ComparePersonByLastName----------");
        System.out.println(sortByLasttName(people));

        System.out.println("---------ComparePersonByAge----------");
        System.out.println(sortByAge(people));

        System.out.println("---------Unsortered People----------");
        System.out.println(people);

    }

    //хороший тон - работать с копией списка
    public static List<Person> sortByFirstName(List<Person> people) {
        List<Person> ret = new ArrayList<>(people);
        Collections.sort(ret);
        return ret;
    }

    public static List<Person> sortByLasttName(List<Person> people) {
        List<Person> ret = new ArrayList<>(people);
        Collections.sort(ret, new ComparePersonByLastName());
        return ret;
    }

    public static List<Person> sortByAge(List<Person> people) {
        List<Person> ret = new ArrayList<>(people);
        Collections.sort(ret, new ComparePersonByAge());
        return ret;
    }
}


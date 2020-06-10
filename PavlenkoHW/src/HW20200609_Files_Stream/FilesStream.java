package HW20200609_Files_Stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Given a text file people.csv:

Ivan;Petrov;25
Piotr;Ivanov;40
Anna;Petrova;34
Sergey;Lukichev;40
print all persons as java objects
Implement a function, which returns info about an oldest/youngest person
Implement a function, which returns a list of persons of a similar age (List<Person> getPeopleByAge(int age))
 */
public class FilesStream {
    public static void main(String[] args) throws IOException {
        String file = "people.csv";

        List<Person> persons = createListPerson(file);

        System.out.println(getPeopleByAge(persons, 40));
        System.out.println(getOldes(persons));
        System.out.println(getYoungest(persons));

    }

    public static List<Person> createListPerson(String file) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(file));
        List<Person> persons = new ArrayList<>();
        //разделяем информацию по строкам
        List<String[]> stringList = lines.map(s -> s.split(";"))
                .collect(Collectors.toList());
        //create list People
        for (String[] s : stringList) {
            persons.add(new Person(s[0], s[1], Integer.parseInt(s[2])));
        }
        return persons;
    }

    // выдает только 1 персону. А если их несколько? Надо как-то попробовать Лист вернуть
    public static Person getOldes(List<Person> pList) {
        return pList.stream().max(Comparator.comparing(Person::getAge)).get();
    }

    public static Person getYoungest(List<Person> pList) {
        return pList.stream().min(Comparator.comparing(Person::getAge)).get();
    }

    public static List<Person> getPeopleByAge(List<Person> pList, int age) {
        return pList.stream().filter(p -> p.getAge() == age).collect(Collectors.toList());
    }
}

class Person {
    private String name;
    private String lastName;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}

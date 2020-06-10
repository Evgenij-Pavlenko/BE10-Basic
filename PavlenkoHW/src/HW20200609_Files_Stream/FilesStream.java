package HW20200609_Files_Stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

        System.out.println("List of persons of a similar age: \n" + getPeopleByAge(persons, 40));
        System.out.println("Oldest person: " + getOldes(persons));
        System.out.println("Youngest person: " + getYoungest(persons));

    }

    public static List<Person> createListPerson(String file) throws IOException {
        //разделяем информацию по строкам
        Stream<String> lines = Files.lines(Paths.get(file));
        //create list Person
        return lines.map(FilesStream::createPerson).collect(Collectors.toList());
    }

    private static Person createPerson(Object s) {
        String str = (String) s;
        //Separate date with regex ";"
        String[] sArr = str.split(";");
        return new Person(sArr[0], sArr[1], Integer.parseInt(sArr[2]));
    }

    // выдает только 1 персону. А если их несколько? Надо как-то попробовать Лист вернуть
    public static List<Person> getOldes(List<Person> pList) {
        int max = maxAge(pList);
        return pList.stream().filter(p -> p.getAge() == max).collect(Collectors.toList()); // return all person with max age
//        return pList.stream().max(Comparator.comparing(Person::getAge)).get(); // - return only 1 person
    }

    public static List<Person> getYoungest(List<Person> pList) {
        int min = minAge(pList);
        return pList.stream().filter(p -> p.getAge() == min).collect(Collectors.toList()); // return all person with max age
//        return pList.stream().min(Comparator.comparing(Person::getAge)).get(); //- return only 1 person
    }

    public static List<Person> getPeopleByAge(List<Person> pList, int age) {
        return pList.stream().filter(p -> p.getAge() == age).collect(Collectors.toList());
    }

    public static int maxAge(List<Person> list) {
        int max = 0;
        for (Person p : list) {
            if (p.getAge() > max) max = p.getAge();
        }
        return max;
    }

    public static int minAge(List<Person> list) {
        int min = 100;
        for (Person p : list) {
            if (p.getAge() < min) min = p.getAge();
        }
        return min;
    }

}

package HW11052020;

import java.util.Comparator;

public class ComparePersonByAge implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.age > o2.age) return 1;
        else if (o1.age < o2.age) return -1;
        return 0;
//        плохая практика?
//        return o1.age-o2.age;
    }
}

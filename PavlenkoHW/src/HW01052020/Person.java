package HW01052020;

import java.util.LinkedList;
import java.util.List;

/**
 * 1. Есть два класса: Address с полями улица и номер дома и Person с полями имя и
 * Address. Нужно написать функцию:
 * List<Address> getAddresses(List<Person> persons)
 * то есть по списку persons возвращать список их адресов.
 */
public class Person {
    String name;
    Address address;

    public Person(String name, Address addres) {
        this.name = name;
        this.address = addres;
    }

    public List<Address> getAddress(List<Person> persons) {
        List<Address> list = new LinkedList<>();
        for (Person p : persons) {
            list.add(p.address);
        }
        return list;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", addres=" + address +
                '}';
    }
}
class Address {
    String street;
    int numHouse;

    public Address(String street, int numHouse) {
        this.street = street;
        this.numHouse = numHouse;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", numHouse=" + numHouse +
                '}';
    }
}


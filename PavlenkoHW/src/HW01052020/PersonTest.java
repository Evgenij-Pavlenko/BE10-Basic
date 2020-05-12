package HW01052020;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    @Test
    public void testGetAddresses() {
        Address a1 = new Address("Berliner Str.", 1);
        Address a2 = new Address("Potsdamer Str.", 2);
        Address a3 = new Address("Aleksander Platz.", 3);
        List<Person> pList = new LinkedList<>();
        pList.add(new Person("Max", a1));
        pList.add(new Person("Joe", a2));
        pList.add(new Person("Pol", a3));
        List<Address> aListExpected = new LinkedList<>();
        aListExpected.add(a1);
        aListExpected.add(a2);
        aListExpected.add(a3);
        for (int i = 0; i < pList.size(); i++) {
            assertEquals(aListExpected.get(i), pList.get(i).address);
        }
    }
}

package HW20200606_Stream;

import org.junit.Test;

import java.util.*;

import static HW20200606_Stream.StreamMain.*;
import static org.junit.Assert.*;

public class StreamMainTest {
    Address a2 = new Address("Potsdamer Str", 2);
    Address a3 = new Address("Potsdamer Str", 3);
    Address a4 = new Address("Potsdamer Str", 4);
    Person p1 = new Person("Vasja", 16, new Address("Potsdamer Str", 1));
    Person p2 = new Person("Petja", 18, a2);
    Person p3 = new Person("Mike", 17, a3);
    Person p4 = new Person("Bob", 25, a4);
    // для задания 3 - testGetMapAge()
    Person p11 = new Person("Vasja", 16, new Address("Potsdamer Str", 1));
    Person p21 = new Person("Petja", 18, a2);
    Person p31 = new Person("Mike", 17, a3);
    Person p111 = new Person("Vasja", 16, new Address("Potsdamer Str", 1));
    // для задания 4 и 5 -
    Person4 p4_1 = new Person4("Ivan");
    Person4 p4_2 = new Person4("Petr");
    BankAccount ba1 = new BankAccount("DE89 3704 0044 0532 0130 01", p4_1);
    BankAccount ba2 = new BankAccount("DE89 3704 0044 0532 0130 02", p4_1);
    BankAccount ba3 = new BankAccount("DE89 3704 0044 0532 0130 03", p4_2);
    BankAccount ba4 = new BankAccount("DE89 3704 0044 0532 0130 04", p4_2);


    @Test
    public void testAge17() {

        List<Person> list = Arrays.asList(p1, p2, p3, p4);
        List actual = ageOver17(list);
        List<Address> expected = Arrays.asList(a2, a3, a4);
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }

    @Test
    public void testnamesUnduplikate() {
        List<String> list = Arrays.asList("one", "two", "three", "one", "three");
        List<String> actual = namesUnduplikate(list);
        List<String> expected = Arrays.asList("one", "two", "three");
        assertTrue(actual.size() == 3);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetMapAge() {
        List<Person> list = Arrays.asList(p1, p2, p3, p11, p21, p31, p111);
        Map<Integer, List<Person>> actual = getMapAge(list);
        Map<Integer, List<Person>> expected = new LinkedHashMap<>();
        List<Person> l1 = new ArrayList<>();
        List<Person> l2 = new ArrayList<>();
        List<Person> l3 = new ArrayList<>();
        l1.add(p1);
        l1.add(p11);
        l1.add(p111);
        l2.add(p2);
        l2.add(p21);
        l3.add(p3);
        l3.add(p31);
        expected.put(p1.age, l1);
        expected.put(p2.age, l2);
        expected.put(p3.age, l3);
        assertTrue(actual.size() == 3);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetBankAccountForPerson() {
        List<BankAccount> list = Arrays.asList(ba1, ba2, ba3, ba4);
        Map<Person4, List<BankAccount>> actual = getBankAccountForPerson(list);
        Map<Person4, List<BankAccount>> expected = new LinkedHashMap<>();
        List<BankAccount> lb1 = Arrays.asList(ba1, ba2);
        List<BankAccount> lb2 = Arrays.asList(ba3, ba4);
        expected.put(p4_1, lb1);
        expected.put(p4_2, lb2);
        assertTrue(actual.size() == expected.size());
        assertEquals(expected, actual);
    }

    @Test
    public void testgetIBANNStarList() {
        List<BankAccount> list = Arrays.asList(ba1, ba2);
        List<String> actual = getIBANNStarList(list);
        List<String> expected = Arrays.asList("DE8************************", "DE8************************");

        assertTrue(actual.size() == expected.size());
        assertEquals(expected, actual);
    }

    @Test
    public void testWordCount() {
        String str = "Asd bsd sdfg asdfg bnhg bdf";
        int actual = wordCount(str, "b");
        int expected = 3;
        assertEquals(expected, actual);
    }


    @Test
    public void testIsInteger() {
        assertTrue(isInteger("12"));
        assertFalse(isInteger("12,2"));
        assertFalse(isInteger("12.3"));
        assertFalse(isInteger("1abc"));
    }

//    @Test
//    public void testGetIBANNByPerson() {
//
//        String ba1 = "DE89 3704 0044 0532 0130 01";
//        String ba2 = "DE89 3704 0044 0532 0130 02";
//        String ba3 = "DE89 3704 0044 0532 0130 03";
//        String ba4 = "DE89 3704 0044 0532 0130 04";
//        List<String> bal1 = Arrays.asList(ba1, ba2);
//        List<String> bal2 = Arrays.asList(ba3, ba4);
//        Person8 p8_1 = new Person8("Ivan", bal1);
//        Person8 p8_2 = new Person8("Petr", bal2);
//        List<Person8> pl = Arrays.asList(p8_1, p8_2);
//        List<String> actual = getIBANNByPerson(pl);
//        Map<Person8, List<String>> expected = new LinkedHashMap<>();
//        String ba1exp = "DE8*************************";
//        List<String> expList = Arrays.asList(ba1exp, ba1exp);
//        expected.put(p8_1, expList);
//        expected.put(p8_2, expList);
//        assertEquals(expected, actual);
//
//    }

    @Test
    public void testGeneralAgeOver17(){
        List<Person> list = Arrays.asList(p1,p2,p3,p4);
        int actual = generalAgeOver17(list);
        int expected = 60; //18+17+25=60
        assertEquals(expected,actual);
    }


}

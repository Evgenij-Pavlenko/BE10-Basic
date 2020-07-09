package HW20200704IO;

public class Person2 {
    private String firstName;
    private String lastName;
    private int sum;

    public Person2(String firstName, String lastName, int sum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sum = sum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sum=" + sum +
                '}';
    }
}

package HW20200616Exeption;

public class Customer {
    String name;
    int age;
    BankAccount account;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public BankAccount getAccount() {
        return account;
    }

    public Customer(String name, int age, BankAccount account) {
        this.name = name;
        this.age = age;
        this.account = account;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", " + account +
                '}';
    }
}
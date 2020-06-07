package HW20200606_Stream;

public class BankAccount {
    String IBANN;
    Person4 owner;

    public BankAccount(String IBANN, Person4 owner) {
        this.IBANN = IBANN;
        this.owner = owner;
    }
}
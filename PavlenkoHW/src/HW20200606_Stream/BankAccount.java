package HW20200606_Stream;

public class BankAccount {
    private String IBANN;
    private Person4 owner;

    public String getIBANN() {
        return IBANN;
    }

    public Person4 getOwner() {
        return owner;
    }

    public BankAccount(String IBANN, Person4 owner) {
        this.IBANN = IBANN;
        this.owner = owner;
    }
}
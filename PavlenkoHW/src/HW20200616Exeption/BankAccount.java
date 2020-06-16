package HW20200616Exeption;

public class BankAccount {
    String ibann;

    public String getIbann() {
        return ibann;
    }

    public BankAccount(String ibann) {
        this.ibann = ibann;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "ibann='" + ibann + '\'' +
                '}';
    }
}
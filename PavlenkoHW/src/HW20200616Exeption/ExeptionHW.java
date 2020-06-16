package HW20200616Exeption;

import java.util.Arrays;
import java.util.List;

public class ExeptionHW {
    public static void main(String[] args) throws IBANNLengthExeption, YoungAls17YearExeption, CountryExeption {

        List<Customer> list = Arrays.asList(new Customer("User1", 18, new BankAccount("DE16000012345678")),
                new Customer("User2", 15, new BankAccount("DE16000012345678")),
                new Customer("User3", 18, new BankAccount("DA160000123456789")),
                new Customer("User4", 18, new BankAccount("DE1600001234567")),
                new Customer("User5", 18, new BankAccount("UA16000012345678"))
        );
        checkListCustomers(list);

    }

    public static void checkListCustomers(List<Customer> customers) {

        for (Customer customer : customers) {
            checkCustomer(customer);
        }

    }

    public static void checkCustomer(Customer customer) {
        System.out.println("For " + customer);
        int countExeption = 0;
        try {
            checkAge(customer);
            countExeption++;
        } catch (YoungAls17YearExeption ex) {
            System.out.println(ex);
        }
        try {
            checkIbannLength(customer.getAccount());
            countExeption++;
        } catch (IBANNLengthExeption ex) {
            System.out.println(ex);
        }
        try {
            checkIbannCountry(customer.getAccount());
            countExeption++;
        } catch (CountryExeption ex) {
            System.out.println(ex);
        } finally {
            if (countExeption==3){
                System.out.println("All right");
            }
        }
        System.out.println("----------------------");

    }

    private static void checkAge(Customer customer) throws YoungAls17YearExeption {
        if (customer.getAge() < 17) {
            throw new YoungAls17YearExeption(" Younger, als 17 year ");
        }

    }

    private static void checkIbannLength(BankAccount bankAccount) throws IBANNLengthExeption {
        if (bankAccount.getIbann().length() != 16) {
            throw new IBANNLengthExeption("Length's IBANN isn't 16");
        }

    }

    private static void checkIbannCountry(BankAccount bankAccount) throws CountryExeption {
        if (!"DE".equals(bankAccount.getIbann().substring(0, 2))) {
            throw new CountryExeption("Wrong country");
        }

    }
}


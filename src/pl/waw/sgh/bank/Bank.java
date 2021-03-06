package pl.waw.sgh.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Customer> customerList = new ArrayList<>();

    private List<Account> accountList = new ArrayList<>();

    public Customer newCustomer(String firstName, String lastName, String email) {
        Customer c = new Customer(firstName, lastName, email);
        customerList.add(c);
        return c;
    }

    public Account newAccount(boolean isDebitAccount, String currency, Customer customer) {
        Account a;
        if (isDebitAccount) {
            a = new DebitAccount(currency, customer);
        } else {
            a = new SavingsAccount(currency, customer);
        }
        accountList.add(a);
        return a;
    }

    public Account newDebitAccount(String currency, Customer customer) {
        return newAccount(true, currency, customer);
    }

    public Account newSavingsAccount(String currency, Customer customer) {
        return newAccount(false, currency, customer);
    }

    public Account findAccountById(Integer accId) throws AccountNotFoundException {
        //TODO: May be needed for transfer...
        // Loop through list of accounts and if accId matches then return that account
        for (Account acc : accountList) {
            if (accId.equals(acc.getId()))
                return acc;
        }
        throw new AccountNotFoundException("Account with ID: " + accId + " not found!", accId);
        //return null;
    }

    public void transfer(Integer fromAccountId, Integer toAccountId, Double amount)
            throws AccountNotFoundException, NotEnoughMoneyException, NegativeAmountException {
        //TODO: add checks for different situations when charge may not be run successfully
        if (amount < 0) {
            throw new InvalidAmountException("Amount lower than zero");
        }
        
        this.balance = balance.subtract(amount);
        Account fromAccount = findAccountById(fromAccountId);
        Account toAccount = findAccountById(toAccountId);
        fromAccount.charge(amount);
        toAccount.deposit(amount);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "\tcusts:\n" + customerList +
                "\n\taccounts:\n" + accountList +
                '}';
    }
}

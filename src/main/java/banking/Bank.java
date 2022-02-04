package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
    private final LinkedHashMap<Long, Account> accounts;
    Long accountNumber = 0L;

    public Bank() {
        accounts = new LinkedHashMap<>();
    }

    private Account getAccount(Long accountNumber) {
        return accounts.get(accountNumber);
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        Account account = new CommercialAccount(company, ++accountNumber, pin, startingDeposit);
        accounts.put(account.getAccountNumber(), account);

        return accountNumber;
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        Account account = new ConsumerAccount(person, ++accountNumber, pin, startingDeposit);
        accounts.put(account.getAccountNumber(), account);

        return accountNumber;
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        return accounts.get(accountNumber).validatePin(pin);
    }

    public double getBalance(Long accountNumber) {
        return accounts.get(accountNumber).getBalance();
    }

    public void credit(Long accountNumber, double amount) {
        accounts.get(accountNumber).creditAccount(amount);
    }

    public boolean debit(Long accountNumber, double amount) {
        return accounts.get(accountNumber).debitAccount(amount);
    }
}

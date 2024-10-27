package Labs.DecoratorPattern;

import java.util.Collection;

public interface AccountService {
    Account createAccount(String accountNumber, String customerName,AccountType accountType);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void addInterest(String accountNumber);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
}

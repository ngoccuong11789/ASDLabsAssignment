package Labs.CommandPattern;

import java.util.Collection;
import java.util.Stack;

public class AccountServiceImpl implements AccountService {
	private AccountDAO accountDAO;
	private Stack<Command> commandHistory = new Stack<>();
	
	public AccountServiceImpl(){
		accountDAO = new AccountDAOImpl();
	}

	public Account createAccount(String accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		
		accountDAO.saveAccount(account);
		
		return account;
	}

	public void deposit(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		//account.deposit(amount);
		Command depositCommand = new DepositCommand(account, amount);
		depositCommand.execute();
		commandHistory.push(depositCommand);
		
		accountDAO.updateAccount(account);
	}

	public Account getAccount(String accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);

		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		//account.withdraw(amount);
		Command withdrawCommand = new WithdrawCommand(account, amount);
		withdrawCommand.execute();
		commandHistory.push(withdrawCommand);
		accountDAO.updateAccount(account);
	}



	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		//fromAccount.transferFunds(toAccount, amount, description);
		Command transferFundsCommand = new TransferFundsCommand(fromAccount, toAccount, amount, description);
		transferFundsCommand.execute();
		commandHistory.push(transferFundsCommand);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
	}

	public void undoLastCommand() {
		if(!commandHistory.isEmpty()) {
			Command lastCommand = commandHistory.pop();
			lastCommand.undo();

		}
	}

}

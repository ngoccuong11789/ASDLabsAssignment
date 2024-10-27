package Labs.CommandPattern;

public class WithdrawCommand implements Command{

    private Account account;
    private double amount;

    public WithdrawCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        this.account.withdraw(amount);
    }

    @Override
    public void undo() {
        this.account.deposit(amount);
    }
}

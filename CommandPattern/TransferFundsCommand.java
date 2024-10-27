package Labs.CommandPattern;

public class TransferFundsCommand implements Command{

    private Account fromAccount;
    private Account toAccount;
    private double amount;
    private String description;

    public TransferFundsCommand(Account fromAccount, Account toAccount, double amount, String description) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public void execute() {
        this.fromAccount.transferFunds(this.toAccount, this.amount, this.description);
    }

    @Override
    public void undo() {
        this.toAccount.transferFunds(this.fromAccount, this.amount, this.description);
    }
}

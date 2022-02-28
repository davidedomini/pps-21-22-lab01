package lab01.example.model;

public abstract class AbstractBankAccount implements BankAccount {
    protected final AccountHolder holder;
    protected double balance;
    protected FeeStrategy feeStrategy;

    public AbstractBankAccount(final int balance, final AccountHolder holder, FeeStrategy feeStrategy) {
        this.balance = balance;
        this.holder = holder;
        this.feeStrategy = feeStrategy;
    }

    @Override
    public AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance = this.balance + amount - this.feeStrategy.computeFee();
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance = this.balance - amount - this.feeStrategy.computeFee();
        }
    }

    private boolean isWithdrawAllowed(final double amount) {
        return this.balance >= (amount- this.feeStrategy.computeFee());
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}

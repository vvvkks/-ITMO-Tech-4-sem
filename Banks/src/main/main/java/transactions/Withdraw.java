package transactions;

import accounts.Account;

/**
 * This class represents a withdrawal transaction from a bank account.
 * @author Kurilova Viktoriia
 */
public class Withdraw extends Transaction {
    private final Account account;
    private final float money;

    /**
     * Constructs a new Withdrawal object with the specified account and money amount.
     * @param account the account from which the money is withdrawn.
     * @param money the amount of money to be withdrawn.
     */
    public Withdraw(Account account, float money) {
        this.account = account;
        this.money = money;
    }

    /**
     * Cancels the withdrawal transaction and adds the money back to the account.
     */
    @Override
    public void cancel() {
        isTransactionExecuted = true;
        account.creditFunds(money);
    }

    /**
     * Executes the withdrawal transaction and deducts the money from the account.
     */
    @Override
    public void execute() {
        isTransactionExecuted = false;
        account.deductFunds(money);
    }
}

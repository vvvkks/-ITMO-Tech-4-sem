package transactions;

import accounts.Account;


/**
 * Represents a transaction to add money to an account.
 * @author Kurilova Viktoriia
 */
public class AddMoney extends Transaction {
    private final Account account;
    private final float money;

    /**
     * Constructs a new AddMoney transaction.
     * @param account The account to add money to.
     * @param money The amount of money to add.
     */
    public AddMoney(Account account, float money) {
        this.account = account;
        this.money = money;
    }

    /**
     * Cancels the transaction by deducting the added money from the account.
     */
    @Override
    public void cancel() {
        isTransactionExecuted = true;
        account.deductFunds(money);
    }

    /**
     * Executes the transaction by crediting the account with the added money.
     */
    @Override
    public void execute() {
        isTransactionExecuted = false;
        account.creditFunds(money);
    }
}

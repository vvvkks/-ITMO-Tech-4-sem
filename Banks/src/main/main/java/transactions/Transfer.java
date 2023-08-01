package transactions;

import accounts.Account;
import exception.BanksException;

/**
 * A class representing a transfer transaction between two accounts.
 * The amount of money transferred should be greater than a pre-defined minimalMoney value.
 * Implements the abstract methods of the Transaction class, cancel() and execute().
 * @author Kurilova Viktoriia
 */
public class Transfer extends Transaction {
    private static final float minimalMoney = 0;
    private final Account sender;
    private final Account recipient;
    private final float money;

    /**
     * Constructs a new Transfer object with the specified sender, recipient, and money.
     * @param from the account from which the money is being transferred
     * @param to the account to which the money is being transferred
     * @param money the amount of money being transferred
     * @throws BanksException if the specified money is less than or equal to the minimalMoney value
     */
    public Transfer(Account from, Account to, float money) {
        if (money <= minimalMoney)
            throw new BanksException("Not enough money");
        this.sender = from;
        this.recipient = to;
        this.money = money;
    }

    /**
     * Cancels the transaction by transferring the money back to the sender and deducting it from the recipient.
     */
    @Override
    public void cancel() {
        isTransactionExecuted = true;
        sender.creditFunds(money);
        recipient.deductFunds(money);

    }

    /**
     * Executes the transaction by deducting the money from the sender and transferring it to the recipient.
     */
    @Override
    public void execute() {
        isTransactionExecuted = false;
        sender.deductFunds(money);
        recipient.creditFunds(money);

    }
}

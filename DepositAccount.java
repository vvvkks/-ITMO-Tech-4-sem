package accounts;

import banks.Bank;
import clients.Client;
import exception.BanksException;
/**
 *A subclass of Account representing a deposit account.
 *A deposit account has a set time limit, and cannot be withdrawn from before this limit is reached.
 *Once the time limit is reached, the account holder may withdraw their money and collect interest.
 * @author Kurilova Viktoriia
 */
public class DepositAccount extends Account {
    private final int time;
    private int timeLimit;
    private float moneyBuffer;

    /**
     * Constructor for a DepositAccount object.
     * @param client The client who owns the account.
     * @param balance The starting balance of the account.
     * @param bank The bank where the account is held.
     * @param time The time limit for the account, in days.
     */
    public DepositAccount(Client client, float balance, Bank bank, int time) {
        super(client, balance, bank);
        int timeLimit = 0;
        double moneyBuffer = 0;
        this.time = time;
    }

    /**
     * Deducts a specified amount of funds from the account balance.
     * Cannot be used if the account is still within the time limit.
     * @param money The amount of money to deduct from the balance.
     * @throws BanksException If the account is still within the time limit.
     */
    @Override
    public void deductFunds(float money) {
        if (time < 0) {
            throw new BanksException("Can't send money before the release date");
        }
        balance -= money;
    }

    /**
     *Credits a specified amount of funds to the account balance.
     * @param money The amount of money to add to the balance.
     */
    @Override
    public void creditFunds(float money) {
        balance += money;
    }

    /**
     *Advances one day in the account's lifetime.
     * If the account is still within the time limit, the interest is added to a buffer.
     * Once the time limit is reached, the interest is added to the account balance.
     */
    @Override
    public void dayPassed() {
        timeLimit++;
        if (timeLimit <= time) {
            moneyBuffer += (balance * bank.payPercent) / (365 * 100);
        }
        if (timeLimit == time) {
            balance += moneyBuffer;
            moneyBuffer = 0;
        }
    }

    /**
     * No bank commission is charged for deposit accounts, so this method does nothing.
     * @param count The count of bank commission.
     */
    @Override
    public void bankCommission(float count) {
        return;
    }

    /**
     *Returns the current balance of the account.
     * @return The current balance of the account.
     */
    public float getBalance() {
        return balance;
    }
}

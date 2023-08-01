package accounts;

import banks.Bank;
import clients.Client;
import exception.BanksException;
/**
 * The `DebitAccount` class represents a bank account with a positive balance.
 * It is a subclass of the `Account` class and inherits all its properties.
 * A `DebitAccount` can have funds credited or deducted from it, and interest is earned on
 * the account balance over time. It is not subject to bank commission fees.
 * @author Kurilova Viktoriia
 */
public class DebitAccount extends Account {
    /**
     * Creates a new `DebitAccount` object with the specified client, balance, and bank.
     *
     * @param client the client associated with the account
     * @param balance the starting balance of the account
     * @param bank the bank associated with the account
     */
    public DebitAccount(Client client, float balance, Bank bank) {
        super(client, balance, bank);
    }
    /**
     * Credits funds to the account balance.
     *
     * @param money the amount of funds to be credited
     */
    @Override
    public void creditFunds(float money) {
        balance += money;
    }
    /**
     * Deducts funds from the account balance.
     *
     * @param money the amount of funds to be deducted
     * @throws BanksException if the account does not have enough funds to make the deduction
     */
    @Override
    public void deductFunds(float money) {
        if (balance < 0 || balance - money < 0)
            throw new BanksException("Not enough money");
        balance -= money;
    }
    /**
     * Updates the balance of the account by adding interest earned over time.
     */
    @Override
    public void dayPassed() {
        balance += (balance * bank.payPercent) / (365 * 100);
    }
    /**
     * Does nothing, as a `DebitAccount` is not subject to bank commission fees.
     *
     * @param count the commission amount to be charged to the account
     */
    @Override
    public void bankCommission(float count) {
        return;
    }
    /**
     * Gets the current balance of the account.
     *
     * @return the current balance of the account
     */
    public float getBalance() {
        return balance;
    }
}

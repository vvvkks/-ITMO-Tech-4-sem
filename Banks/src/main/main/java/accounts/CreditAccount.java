package accounts;

import banks.Bank;
import clients.Client;
import exception.BanksException;
/**
 * The Credit-Account class is inherited from the Account class, in which all credit transactions take place, such as:
 * replenishment of balance, withdrawal of money and tracking of the commission provided by the bank.
 * @author Kurilova Viktoriia
 */
public class CreditAccount extends Account {
    /**
     *Constructor method for CreditAccount.
     *@param client the client that owns this account
     *@param balance the initial balance of the account
     *@param bank the bank that serves the account
     */
    public CreditAccount(Client client, float balance, Bank bank) {
        super(client, balance, bank);
    }
    /**
     *Overrides the Account class's dayPassed method.
     *If the balance of the account is negative and does not exceed the credit limit,
     *a commission is charged by the bank.
     */
    @Override
    public void dayPassed() {
        if (balance < 0 && balance > -bank.creditLimit) {
            balance -= bank.commissionPercent;
        }
    }
    /**
     *Overrides the Account class's deductFunds method.
     *If the deduction resulted in a balance below the credit limit,
     *a BanksException is thrown.
     *@param money the amount of funds to be deducted
     */
    @Override
    public void deductFunds(float money) {
        if (balance - money < -bank.creditLimit) {
            throw new BanksException("More than limit");
        }
        balance -= money;
    }
    /**
     * Overrides the Account class's creditFunds method.
     * Add funds to the account balance.
     * @param money the amount of funds to be credited
     */
    @Override
    public void creditFunds(float money) {
        balance += money;
    }

    /**
     *     Overrides the Account class's bankCommission method.
     *     Charges a commission on the account balance, if the new balance is greater than or equal to
     *     the negative commission amount.
     *     @param count the amount of commission to be charged
     */
    @Override
    public void bankCommission(float count) {
        float newBalance = balance - bank.commissionPercent;
        if (newBalance >= -bank.commissionPercent) {
            balance = newBalance;
        }
    }
}

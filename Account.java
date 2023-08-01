package accounts;


import banks.Bank;
import clients.Client;
import notification.Notification;
import transactions.Transaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;
import java.util.List;
/**
 * The account class creates an account for the client by linking to a specific bank that the client has chosen.
 * This class already has a specific balance, transaction history, and unique id. It implements the Notification interface to allow for notifications to be sent to the account holder.
 * @author Kurilova Viktoriia
 * @version 1.0
 * @since 2023-02-12
 */
public abstract class Account implements Notification {
    private final LocalDateTime creationTime;
    public final Bank bank;
    private final List<Transaction> transactionHistory;
    public float balance;
    private final Client client;
    private final UUID id;
    private final List<String> messageList;
    /**

     This constructor creates a new account with the given client, balance and bank.
     @param client the client that owns the account
     @param balance the initial balance of the account
     @param bank the bank that the account belongs to
     */
    public Account(Client client, float balance, Bank bank) {
        this.balance = balance;
        this.bank = bank;
        this.client = client;
        transactionHistory = new ArrayList<>();
        id = UUID.randomUUID();
        creationTime = LocalDateTime.now();
        messageList = new ArrayList<>();
    }

    /**
     * This method is used to get creation time and return this time
     * @return creationTime
     */
    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    /**
     * This method is used to get Bank,
     * which serves the customer and return this Bank
     * @return bank
     */
    public Bank getBank() {

        return bank;
    }

    /**
     * This method is used to get Balance,
     * which is contained in the client's account
     * @return balance
     */
    public float getBalance() {

        return balance;
    }

    /**
     * This method changes the balance value
     * @param balance the new balance of the account
     */
    public void setBalance(float balance) {
        this.balance = balance;
    }

    /**
     * This method is used to get TransactionHistory in List structure
     * @return transactionHistory
     */
    public List<Transaction> getTransactionHistory() {

        return transactionHistory;
    }

    /**
     * This method is used to get Client, who uses this account
     * @return client
     */
    public Client getClient() {

        return client;
    }

    /**
     * This method returns the unique identifier for the account.
     * @return id
     */
    public UUID getId() {

        return id;
    }

    /**
     * This method adds a new transaction to the account's transaction history.
     * @param transaction the transaction to add
     */
    public void newTransaction(Transaction transaction) {

        transactionHistory.add(transaction);
    }

    /**
     * This method deducts funds from the account.
     * @param money the amount of money to deduct
     */
    public abstract void deductFunds(float money);

    /**
     * This method credits funds to the account.
     * @param money the amount of money to credit
     */
    public abstract void creditFunds(float money);

    /**
     * This method applies a bank commission to the account.
     * @param money the amount of money to apply the commission to
     */
    public abstract void bankCommission(float money);

    public void dayPassed() {
    }

    /**
     * Overrides the dayPassed method in the Notification interface and adds a new message to the message list
     * @param message the message to add
     */
    @Override
    public void notify(String message) {
        messageList.add(message);
    }
}

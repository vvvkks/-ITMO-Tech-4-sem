package banks;

import accounts.Account;
import accounts.CreditAccount;
import accounts.DebitAccount;
import accounts.DepositAccount;
import clients.Client;
import exception.BanksException;
import notification.Message;
import notification.Notifiable;
import notification.Notification;

import java.util.*;

/**
 * This class represents a bank and contains information about its name, commission percentage, credit limit,
 * and pay percentage. It also stores lists of its clients and various types of accounts. It implements the
 * Notifiable interface to enable notifications for registered accounts.
 * @author Kurilova Viktoriia
 */
public class Bank implements Notifiable {
    private final Map<Account, Notification> accountsNotify;
    private final List<Client> clients;
    private final List<DebitAccount> debitAccounts;
    private final List<CreditAccount> creditAccounts;
    private final List<DepositAccount> depositAccounts;
    private final List<Bank> banks;
    public String name;
    public float commissionPercent;
    public float creditLimit;
    public float payPercent;
    private final UUID id;
    /**
     * Constructor for the Bank class. Initializes the lists of clients and accounts, and sets the bank's name,
     * commission percentage, credit limit, and pay percentage. Also generates a unique ID for the bank.
     * @param name               the name of the bank
     * @param commissionPercent  the commission percentage
     * @param creditLimit        the credit limit
     * @param payPercent         the pay percentage
     */
    public Bank(String name, float commissionPercent, float creditLimit, float payPercent) {
        this.name = name;
        this.commissionPercent = commissionPercent;
        this.creditLimit = creditLimit;
        this.payPercent = payPercent;
        this.id = UUID.randomUUID();
        this.banks = new ArrayList<Bank>();
        this.clients = new ArrayList<Client>();
        this.debitAccounts = new ArrayList<DebitAccount>();
        this.creditAccounts = new ArrayList<CreditAccount>();
        this.depositAccounts = new ArrayList<DepositAccount>();
        accountsNotify = new HashMap<>();
    }

    /**
     * Returns the name of the bank.
     * @return the name of the bank
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the bank.
     * @param name  the new name of the bank
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Returns the commission percentage of the bank.
     * @return the commission percentage
     */
    public float getCommissionPercent() {
        return commissionPercent;
    }
    /**
     * Returns the credit limit of the bank.
     * @return the credit limit
     */
    public float getCreditLimit() {
        return creditLimit;
    }
    /**
     * Returns the pay percentage of the bank.
     * @return the pay percentage
     */
    public float getPayPercent() {
        return payPercent;
    }
    /**
     * Sets the pay percentage of the bank.
     * @param payPercent  the new pay percentage
     */
    public void setPayPercent(float payPercent) {
        this.payPercent = payPercent;
    }
    /**
     * Returns the unique ID of the bank.
     * @return the unique ID of the bank
     */
    public UUID getId() {
        return id;
    }
    /**
     * Opens a new debit account for the specified client with the specified initial balance and adds it to the
     * bank's list of debit accounts.
     * @param client   the client for whom the account is being opened
     * @param balance  the initial balance of the account
     * @param bank     the bank with which the account is associated
     * @return         the newly opened debit account
     */
    public DebitAccount openDebitAccount(Client client, float balance, Bank bank) {
        DebitAccount debitAccount = new DebitAccount(client, balance, bank);
        this.debitAccounts.add(debitAccount);
        return debitAccount;
    }
    /**
     * Opens a new deposit account for a client with the specified balance, bank, and time period.
     * @param client the client for whom to open the account
     * @param balance the initial balance for the account
     * @param bank the bank in which to open the account
     * @param time the time period for the deposit account
     * @return the newly created deposit account
     */
    public DepositAccount openDepositAccount(Client client, float balance, Bank bank, int time) {
        DepositAccount depositAccount = new DepositAccount(client, balance, bank, time);
        this.depositAccounts.add(depositAccount);
        return depositAccount;
    }

    /**
     * Opens a new credit account for a client with the specified balance and bank.
     * @param client the client for whom to open the account
     * @param balance the initial balance for the account
     * @param bank the bank in which to open the account
     * @return the newly created credit account
     */
    public CreditAccount openCreditAccount(Client client, float balance, Bank bank) {
        CreditAccount creditAccount = new CreditAccount(client, balance, bank);
        this.creditAccounts.add(creditAccount);
        return creditAccount;
    }

    /**
     * Adds a new client to the bank's list of clients.
     * @param client the client to add
     * @return the added client
     */
    public Client addClient(Client client) {
        this.clients.add(client);
        return client;
    }

    /**
     * Registers an account and its associated notification with the bank.
     * @param account the account to register
     * @param notification the notification to associate with the account
     * @throws BanksException if the account is already associated with a notification
     */
    @Override
    public void registerAccount(Account account, Notification notification) {
        if (accountsNotify.values().stream().anyMatch(n -> n == notification)) {
            throw new BanksException("This account already notified");
        }
        accountsNotify.put(account, notification);
    }

    /**
     * Removes an account and its associated notification from the bank's records.
     * @param account the account to remove
     * @param notification the notification to disassociate from the account
     */
    @Override
    public void removeAccount(Account account, Notification notification) {
        accountsNotify.entrySet().stream()
                .filter(entry -> entry.getValue() == notification && entry.getKey() == account)
                .findFirst()
                .ifPresent(entry -> accountsNotify.remove(entry.getKey()));
    }

    /**
     * Notifies all registered accounts with the given message and count.
     * @param notificationMap the map of accounts and their associated notifications to notify
     * @param count the count to include in the message
     * @param message the message to send to the accounts
     */
    @Override
    public void notify(Map<Account, Notification> notificationMap, float count, Message message) {
        for (Account observer : notificationMap.keySet()) {
            observer.notify(message.message(observer, count));
        }
    }
}

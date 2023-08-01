package banks;

import clients.Client;
import transactions.Transaction;
import transactions.Transfer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * A central bank class that keeps track of banks, transactions, and clients.
 * The class has the ability to create new banks and add them to its list of banks,
 * create new transactions and add them to its list of transactions, and cancel
 * transactions from its list of transactions.
 * This class can be used as a central hub to manage and oversee banking activities
 * between different banks and clients.
 * @author Kurilova Viktoriia
 */
public class CentralBank {
    private final List<Bank> banks;
    public String name;
    private final List<Transaction> transactions;
    private final List<Client> clients;

    /**
     * Constructs a new instance of the CentralBank class with the given name.
     * @param name the name of the central bank
     */
    public CentralBank(String name) {
        this.name = name;
        clients = new ArrayList<Client>();
        banks = new ArrayList<Bank>();
        transactions = new ArrayList<Transaction>();
    }
    /**
     * Returns the name of the central bank.
     * @return the name of the central bank
     */
    public String getName() {
        return name;
    }

    /**
     * Creates a new bank with the given parameters and adds it to the list of banks.
     * @param name the name of the new bank
     * @param commissionPercent the commission percentage of the new bank
     * @param creditLimit the credit limit of the new bank
     * @param payPercent the pay percentage of the new bank
     * @return the newly created bank
     */
    public Bank createBank(String name, float commissionPercent, float creditLimit, float payPercent) {
        var newBank = new Bank(name, commissionPercent, creditLimit, payPercent);
        banks.add(newBank);
        return newBank;
    }

    /**
     * Adds a new transaction to the list of transactions.
     * @param transaction the transaction to be added
     */
    public void makeTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    /**
     * Cancels a transaction from the list of transactions.
     * @param transaction the transaction to be cancelled
     */
    public void cancelTransaction(Transaction transaction) {
        transaction.cancel();
        transactions.remove(transaction);
    }
}

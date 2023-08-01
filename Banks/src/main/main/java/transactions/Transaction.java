package transactions;

/**
 * This abstract class defines the common behavior and properties of transactions in the banking system.
 * It contains two methods: "cancel" and "execute" which are abstract and must be implemented by the
 * subclasses. The "isTransactionExecuted" property indicates whether the transaction has been executed or not.
 * @author Kurilova Viktoriia
 */
public abstract class Transaction {
    boolean isTransactionExecuted;
    /**
     * Returns the current status of the transaction.
     * @return true if the transaction has been executed, false otherwise.
     */
    public boolean getIsTransactionExecuted() {
        return isTransactionExecuted;
    }

    /**
     * Sets the status of the transaction.
     * @param isTransactionExecuted true if the transaction has been executed, false otherwise.
     */
    public void setTransactionExecuted(boolean isTransactionExecuted) {
        this.isTransactionExecuted = isTransactionExecuted;
    }

    /**
     * This method cancels the transaction and undoes its effects.
     */
    public abstract void cancel();

    /**
     * This method executes the transaction and applies its effects.
     */
    public abstract void execute();
}

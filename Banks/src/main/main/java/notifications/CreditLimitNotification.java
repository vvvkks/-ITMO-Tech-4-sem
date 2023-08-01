package notification;

import accounts.Account;

/**
 * This class represents a credit limit notification message that implements the Message interface.
 * When a credit limit is updated for a specific account, this message is sent to notify the account holder about the updated credit limit.
 * @author Kurilova Viktoriia
 */
public class CreditLimitNotification implements Message {
    /**
     * Generates a message that notifies the account holder of the updated credit limit for the specified account.
     * @param account The account for which the credit limit was updated.
     * @param count The updated credit limit amount.
     * @return A string message that notifies the account holder of the updated credit limit.
     */
    @Override
    public String message(Account account, float count) {
        String message = String.format("Your credit limit on account %s has been updated to %d.", account.getId(), count);
        return message;
    }
}






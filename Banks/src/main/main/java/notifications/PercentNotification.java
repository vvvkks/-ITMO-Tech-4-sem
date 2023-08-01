package notification;

import accounts.Account;


/**
 * A message implementation that notifies clients about updates to their account's percent.
 * @author Kurilova Viktoriia
 */
public class PercentNotification implements Message {
    /**
     * Generates a notification message that informs the client about the updated percent of their account.
     * @param account the account that the message is associated with.
     * @param count the updated percent value.
     * @return a notification message
     */
    @Override
    public String message(Account account, float count) {
        return "Your percent on account " + account.getId() + " has been updated to " + count + ".";
    }
}

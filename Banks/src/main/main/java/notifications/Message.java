package notification;

import accounts.Account;

/**
 * This is an interface for creating messages that can be sent to account holders for various events, such as transactions, updates, or notifications.
 * The message method can be implemented to generate messages specific to different events, depending on the needs of the application.
 * @author Kurilova Viktoriia
 */
public interface Message {
    String message(Account account, float count);

}

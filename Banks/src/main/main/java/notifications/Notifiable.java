package notification;

import accounts.Account;

import java.util.Map;

/**
 * The Notifiable interface defines methods for registering, removing, and notifying accounts with a given notification and message.
 * The registerAccount method is used to register an Account with a specific Notification.
 * The removeAccount method is used to remove a previously registered Account with its Notification.
 * The notify method is used to send a message to a group of Accounts with a specific Notification and message.
 * @author Kurilova Viktoriia
 */
public interface Notifiable {
    void registerAccount(Account account, Notification notification);
    void removeAccount(Account account, Notification notification);
    void notify(Map<Account, Notification> notificationMap, float count, Message message);
}

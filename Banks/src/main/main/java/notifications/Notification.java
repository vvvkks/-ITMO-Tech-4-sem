package notification;

/**
 * The Notification interface defines a single method notify that takes a String parameter message.
 * Classes that implement this interface can be used to notify users or clients of various events or updates related to their accounts or other information.
 * The implementation of the notify method can vary depending on the type of notification being sent, such as email, SMS, or in-app notification.
 * @author Kurilova Viktoriia
 */
public interface Notification {
    void notify(String message);
}

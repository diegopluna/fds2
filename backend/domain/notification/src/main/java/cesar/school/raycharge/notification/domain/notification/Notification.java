package cesar.school.raycharge.notification.domain.notification;

import cesar.school.raycharge.authentication.domain.user.UserId;
import org.jmolecules.ddd.types.AggregateRoot;

import java.util.List;

public class Notification implements Cloneable, AggregateRoot<Notification, NotificationId> {
    private final NotificationId id;
    private List<UserId> recipients;
    private UserId sender;
    private String message;
    private boolean read;


    // with sender
    public Notification(NotificationId id, List<UserId> recipients, UserId sender, String message, boolean read) {
        this.id = id;
        this.recipients = recipients;
        this.sender = sender;
        this.message = message;
        this.read = read;
    }

    // without sender
    public Notification(NotificationId id, List<UserId> recipients, String message) {
        this.id = id;
        this.recipients = recipients;
        this.message = message;
        this.read = false;
    }

    @Override
    public NotificationId getId() {
        return id;
    }

    @Override
    public Notification clone() {
        try {
            return (Notification) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

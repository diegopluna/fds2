package cesar.school.raycharge.notification.domain.notification;

import org.jmolecules.ddd.annotation.Service;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification sendNotification(Notification notification) {

        return notificationRepository.save(notification);
    }
}

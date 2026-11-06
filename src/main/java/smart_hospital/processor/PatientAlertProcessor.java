package smart_hospital.processor;
import smart_hospital.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PatientAlertProcessor {

    private final NotificationService notificationService;
    private final NotificationService emergencyService;

    @Autowired
    public PatientAlertProcessor(
            NotificationService notificationService,
            @Qualifier("emergencyService")
            NotificationService emergencyService) {

        this.notificationService = notificationService;
        this.emergencyService = emergencyService;
    }

    public void processNormalAlert(String patientId, String message) {

        notificationService.sendNotification(patientId, message);
    }

    public void processEmergencyAlert(String patientId, String message) {

        emergencyService.sendNotification(patientId, message);
    }
}


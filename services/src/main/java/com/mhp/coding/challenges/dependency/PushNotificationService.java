package com.mhp.coding.challenges.dependency;

import com.mhp.coding.challenges.dependency.inquiry.Inquiry;
import com.mhp.coding.challenges.dependency.notifications.PushNotificationHandler;
import org.springframework.stereotype.Component;

@Component
public class PushNotificationService implements PushNotification {
    private PushNotificationHandler pushNotificationHandler;

    public PushNotificationService(PushNotificationHandler pushNotificationHandler) {
        this.pushNotificationHandler = pushNotificationHandler;
    }

    @Override
    public void sendNotification(Inquiry inquiry) {
        pushNotificationHandler.sendNotification(inquiry);
    }
}

package com.mhp.coding.challenges.dependency;

import com.mhp.coding.challenges.dependency.notifications.PushNotificationHandler;
import org.springframework.stereotype.Component;

@Component
public class PushNotificationService implements PushNotificationSender {
    private PushNotificationHandler pushNotificationHandler;

    public PushNotificationService(PushNotificationHandler pushNotificationHandler) {
        this.pushNotificationHandler = pushNotificationHandler;
    }

    @Override
    public void sendNotification() {

    }
}

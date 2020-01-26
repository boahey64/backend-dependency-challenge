package com.mhp.coding.challenges.dependency;

import com.mhp.coding.challenges.dependency.inquiry.Inquiry;
import com.mhp.coding.challenges.dependency.notifications.PushNotificationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PushNotificationService implements PushNotificationSender {
    private PushNotificationHandler pushNotificationHandler;

    @Autowired
    public PushNotificationService(PushNotificationHandler pushNotificationHandler) {
        this.pushNotificationHandler = pushNotificationHandler;
    }

    @Override
    public void sendNotification(Map<String, String> inquiryAsMap) {
        Inquiry inquiry = new Inquiry();
        inquiry.setUsername(inquiryAsMap.get("username"));
        inquiry.setRecipient(inquiryAsMap.get("recipient"));
        inquiry.setText(inquiryAsMap.get("text"));

        pushNotificationHandler.sendNotification(inquiry);
    }
}

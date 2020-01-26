package com.mhp.coding.challenges.dependency.service;

import java.util.Map;

public interface PushNotificationSender {
    public void sendNotification(Map<String, String> inquiryAsMap);
}

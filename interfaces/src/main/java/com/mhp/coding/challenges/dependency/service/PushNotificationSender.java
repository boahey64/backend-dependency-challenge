package com.mhp.coding.challenges.dependency.service;

import com.mhp.coding.challenges.dependency.dto.InquiryDto;

import java.util.Map;

public interface PushNotificationSender {
    public void sendNotification(Map<String, String> inquiryAsMap);
    public void sendNotification(InquiryDto inquiryDto);
}

package com.mhp.coding.challenges.dependency;

import com.mhp.coding.challenges.dependency.dto.InquiryDto;
import com.mhp.coding.challenges.dependency.inquiry.Inquiry;
import com.mhp.coding.challenges.dependency.inquiry.InquiryMapper;
import com.mhp.coding.challenges.dependency.notifications.PushNotificationHandler;
import com.mhp.coding.challenges.dependency.service.PushNotificationSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PushNotificationService implements PushNotificationSender {
    private PushNotificationHandler pushNotificationHandler;
    private InquiryMapper inquiryMapper;

    @Autowired
    public PushNotificationService(PushNotificationHandler pushNotificationHandler, InquiryMapper inquiryMapper) {
        this.pushNotificationHandler = pushNotificationHandler;
        this.inquiryMapper = inquiryMapper;
    }

    @Override
    public void sendNotification(Map<String, String> inquiryAsMap) {
        Inquiry inquiry = inquiryMapper.map(inquiryAsMap);

        pushNotificationHandler.sendNotification(inquiry);
    }

    @Override
    public void sendNotification(InquiryDto inquiryDto) {
        Inquiry inquiry = inquiryMapper.mapFroDto(inquiryDto);

        pushNotificationHandler.sendNotification(inquiry);
    }
}

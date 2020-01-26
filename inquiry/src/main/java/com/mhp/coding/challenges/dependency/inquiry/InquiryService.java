package com.mhp.coding.challenges.dependency.inquiry;

import com.mhp.coding.challenges.dependency.EmailSender;
import com.mhp.coding.challenges.dependency.PushNotificationSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class InquiryService {
    private EmailSender emailSender;
    private PushNotificationSender pushNotificationSender;
    private InquiryMapper inquiryMapper;

    @Autowired
    public InquiryService(EmailSender emailSender, PushNotificationSender pushNotificationSender, InquiryMapper inquiryMapper) {
        this.emailSender = emailSender;
        this.pushNotificationSender = pushNotificationSender;
        this.inquiryMapper = inquiryMapper;
    }

    private static final Logger LOG = LoggerFactory.getLogger(InquiryService.class);

    public void create(final Inquiry inquiry) {
        LOG.info("User sent inquiry: {}", inquiry);

        Map<String, String> map = inquiryMapper.map(inquiry);

        emailSender.sendEmail(map);

        pushNotificationSender.sendNotification(inquiryMapper.map(inquiry));
    }

}

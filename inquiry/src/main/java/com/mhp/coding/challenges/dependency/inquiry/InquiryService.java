package com.mhp.coding.challenges.dependency.inquiry;

import com.mhp.coding.challenges.dependency.dto.InquiryDto;
import com.mhp.coding.challenges.dependency.service.EmailSender;
import com.mhp.coding.challenges.dependency.service.PushNotificationSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

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
        InquiryDto inquiryDto = inquiryMapper.mapToDto(inquiry);

        emailSender.sendEmail(inquiryDto);

        pushNotificationSender.sendNotification(inquiryDto);
    }

}

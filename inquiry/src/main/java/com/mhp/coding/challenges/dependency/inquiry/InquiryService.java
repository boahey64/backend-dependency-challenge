package com.mhp.coding.challenges.dependency.inquiry;

import com.mhp.coding.challenges.dependency.EmailSender;
import com.mhp.coding.challenges.dependency.PushNotificationSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InquiryService {
    private EmailSender emailSender;
    private PushNotificationSender pushNotificationSender;

    @Autowired
    public InquiryService(EmailSender emailSender, PushNotificationSender pushNotificationSender) {
        this.emailSender = emailSender;
        this.pushNotificationSender = pushNotificationSender;
    }

    private static final Logger LOG = LoggerFactory.getLogger(InquiryService.class);

    public void create(final Inquiry inquiry) {
        LOG.info("User sent inquiry: {}", inquiry);
    }

}

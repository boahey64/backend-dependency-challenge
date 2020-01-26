package com.mhp.coding.challenges.dependency;

import com.mhp.coding.challenges.dependency.inquiry.Inquiry;
import com.mhp.coding.challenges.dependency.notifications.EmailHandler;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements Email {
    private EmailHandler emailHandler;

    public EmailService(EmailHandler emailHandler) {
        this.emailHandler = emailHandler;
    }

    @Override
    public void sendEmail(Inquiry inquiry) {
        emailHandler.sendEmail(inquiry);
    }
}

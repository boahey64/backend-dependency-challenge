package com.mhp.coding.challenges.dependency;

import com.mhp.coding.challenges.dependency.notifications.EmailHandler;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderService implements EmailSender {
    private EmailHandler emailHandler;

    public EmailSenderService(EmailHandler emailHandler) {
        this.emailHandler = emailHandler;
    }

    @Override
    public void sendEmail() {

    }
}

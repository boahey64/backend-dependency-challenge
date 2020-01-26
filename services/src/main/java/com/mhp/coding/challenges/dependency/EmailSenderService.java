package com.mhp.coding.challenges.dependency;

import com.mhp.coding.challenges.dependency.inquiry.Inquiry;
import com.mhp.coding.challenges.dependency.notifications.EmailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EmailSenderService implements EmailSender {
    private EmailHandler emailHandler;

    @Autowired
    public EmailSenderService(EmailHandler emailHandler) {
        this.emailHandler = emailHandler;
    }

    @Override
    public void sendEmail(Map<String, String> inquiryAsMap) {
        Inquiry inquiry = new Inquiry();
        inquiry.setUsername(inquiryAsMap.get("username"));
        inquiry.setRecipient(inquiryAsMap.get("recipient"));
        inquiry.setText(inquiryAsMap.get("text"));

        emailHandler.sendEmail(inquiry);
    }
}

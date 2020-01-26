package com.mhp.coding.challenges.dependency;

import com.mhp.coding.challenges.dependency.inquiry.Inquiry;
import com.mhp.coding.challenges.dependency.inquiry.InquiryMapper;
import com.mhp.coding.challenges.dependency.notifications.EmailHandler;
import com.mhp.coding.challenges.dependency.service.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EmailSenderService implements EmailSender {
    private EmailHandler emailHandler;
    private InquiryMapper inquiryMapper;

    @Autowired
    public EmailSenderService(EmailHandler emailHandler, InquiryMapper inquiryMapper) {
        this.emailHandler = emailHandler;
        this.inquiryMapper = inquiryMapper;
    }

    @Override
    public void sendEmail(Map<String, String> inquiryAsMap) {
        Inquiry inquiry = inquiryMapper.map(inquiryAsMap);

        emailHandler.sendEmail(inquiry);
    }
}

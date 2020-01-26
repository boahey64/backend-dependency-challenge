package com.mhp.coding.challenges.dependency.service;

import com.mhp.coding.challenges.dependency.dto.InquiryDto;

import java.util.Map;

public interface EmailSender {
    public void sendEmail(Map<String, String> inquiryAsMap);
    public void sendEmail(InquiryDto inquiryDto);

}

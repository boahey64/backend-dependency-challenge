package com.mhp.coding.challenges.dependency;

import java.util.Map;

public interface EmailSender {
    public void sendEmail(Map<String, String> inquiryAsMap);

}

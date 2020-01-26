package com.mhp.coding.challenges.dependency.inquiry;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class InquiryMapper {

    public Map<String, String> map(Inquiry inquiry) {
        Map<String, String> map = Stream.of(new String[][] {
                { "username", inquiry.getUsername() },
                { "recipient", inquiry.getRecipient() },
                { "text", inquiry.getText() },
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        return map;
    }

    public Inquiry map(Map<String, String> inquiryAsMap) {
        Inquiry inquiry = new Inquiry();
        inquiry.setUsername(inquiryAsMap.get("username"));
        inquiry.setRecipient(inquiryAsMap.get("recipient"));
        inquiry.setText(inquiryAsMap.get("text"));

        return inquiry;
    }

}

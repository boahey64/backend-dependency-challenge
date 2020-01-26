package com.mhp.coding.challenges.dependency.inquiry;

import com.mhp.coding.challenges.dependency.dto.InquiryDto;
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


    public InquiryDto mapToDto(Inquiry inquiry) {

        return new InquiryDto(
                inquiry.getUsername(),
                inquiry.getRecipient(),
                inquiry.getText());
    }

    public Inquiry mapFroDto(InquiryDto inquiryDto) {
        Inquiry inquiry = new Inquiry();
        inquiry.setUsername(inquiryDto.getUsername());
        inquiry.setRecipient(inquiryDto.getRecipient());
        inquiry.setText(inquiryDto.getText());

        return inquiry;
    }

}

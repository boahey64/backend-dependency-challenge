package com.mhp.coding.challenges.dependency.inquiry;

import com.mhp.coding.challenges.dependency.dto.InquiryDto;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class InquiryMapper {

    public InquiryDto map(Inquiry inquiry) {

        return new InquiryDto(
                inquiry.getUsername(),
                inquiry.getRecipient(),
                inquiry.getText());
    }

    public Inquiry map(InquiryDto inquiryDto) {
        Inquiry inquiry = new Inquiry();
        inquiry.setUsername(inquiryDto.getUsername());
        inquiry.setRecipient(inquiryDto.getRecipient());
        inquiry.setText(inquiryDto.getText());

        return inquiry;
    }

}

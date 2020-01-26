package com.mhp.coding.challenges.dependency.dto;

public class InquiryDto {
    private String username;
    private String recipient;
    private String text;

    public InquiryDto(String username, String recipient, String text) {
        this.username = username;
        this.recipient = recipient;
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

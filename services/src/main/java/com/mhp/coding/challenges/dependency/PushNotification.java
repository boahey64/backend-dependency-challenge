package com.mhp.coding.challenges.dependency;

import com.mhp.coding.challenges.dependency.inquiry.Inquiry;

public interface PushNotification {
    public void sendNotification(final Inquiry inquiry);
}

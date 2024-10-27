package com.learning.notificationservice.request;

public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String message
) {
}

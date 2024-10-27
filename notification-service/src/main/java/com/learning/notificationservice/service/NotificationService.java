package com.learning.notificationservice.service;

import org.springframework.stereotype.Service;

import com.learning.notificationservice.request.NotificationRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {

    public void send(NotificationRequest notificationRequest) {
        System.out.println("Hello-world");
    }
}

package com.learning.notificationservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.notificationservice.request.NotificationRequest;
import com.learning.notificationservice.service.NotificationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "notification-service/v1/notification")
public class NotificationController {

    private final NotificationService notificationService;

//    @PostMapping
//    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
//        logger.info("New notification... {}", notificationRequest);
//        notificationService.send(notificationRequest);
//    }

}

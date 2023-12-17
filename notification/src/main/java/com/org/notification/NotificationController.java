package com.org.notification;

import com.org.clients.notification.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService){
        this.notificationService = notificationService;
    }
    @PostMapping("/")
    public boolean sendNotification(@RequestBody NotificationRequest notificationRequest){
        log.info("Notification will be sent to "+notificationRequest.toCustomerName());
        return notificationService.sendNotification(notificationRequest);
    }
}

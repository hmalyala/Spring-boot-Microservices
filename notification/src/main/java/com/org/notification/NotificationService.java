package com.org.notification;

import com.org.clients.notification.NotificationRequest;
import com.org.customer.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository){
        this.notificationRepository = notificationRepository;
    }

    public boolean sendNotification(NotificationRequest notificationRequest){
        notificationRepository.save(Notification.builder()
                .message(notificationRequest.message())
                .sender("Spectre")
                .sentAt(LocalDateTime.now())
                .toCustomerEmail(notificationRequest.toCustomerName())
                .toCustomerId(notificationRequest.toCustomerId())
                .build()
        );

        return true;
    }
}

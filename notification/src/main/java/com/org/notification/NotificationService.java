package com.org.notification;

import com.org.clients.notification.NotificationRequest;
import com.org.customer.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
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

    @KafkaListener(topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void sendNotificationFromKafka(NotificationRequest notificationRequest){
        log.info("Received message payload "+ notificationRequest);
        notificationRepository.save(Notification.builder()
                .message(notificationRequest.message())
                .sender("Spectre")
                .sentAt(LocalDateTime.now())
                .toCustomerEmail(notificationRequest.toCustomerName())
                .toCustomerId(notificationRequest.toCustomerId())
                .build()
        );
    }
}

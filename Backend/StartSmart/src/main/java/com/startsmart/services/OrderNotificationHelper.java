package com.startsmart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

public class OrderNotificationHelper {

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	public void sendMessageToUser(String userId, String queue, String message) {
		messagingTemplate.convertAndSend("queue/order/" + userId, "order made");
	}
}

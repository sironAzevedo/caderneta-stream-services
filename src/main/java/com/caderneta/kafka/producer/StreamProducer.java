package com.caderneta.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.caderneta.model.ContaDTO;
import com.caderneta.model.UserDTO;

@Service
public class StreamProducer {

	@Value(value = "${kafka.topic.user}")
	private String topicUser;
	
	@Value(value = "${kafka.topic.conta}")
	private String topicAccount;

	private static final Logger logger = LoggerFactory.getLogger(StreamProducer.class);

	@Autowired
	private KafkaTemplate<String, Object> streamTemplate;

	public void sendUser(UserDTO user) {
		logger.info(String.format("Producing %s, user: %s", topicUser, user.toString()));
		this.streamTemplate.send(topicUser, user);
	}

	public void sendAccount(ContaDTO account) {
		logger.info(String.format("Producing %s, account: %s", topicAccount, account.toString()));
		this.streamTemplate.send(topicAccount, account);
	}
}

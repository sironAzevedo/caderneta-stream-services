package com.caderneta.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@RefreshScope
public class KafkaTopicConfig {

	@Value(value = "${kafka.topic.user}")
	private String topicUser;
	
	@Value(value = "${kafka.topic.conta}")
	private String topicAccount;

	@Bean
	@Profile("!prod")
	public NewTopic topicUser() {
		return new NewTopic(topicUser, 3, (short) 1);
	}
	
	@Bean
	@Profile("!prod")
	public NewTopic topicAccount() {
		return new NewTopic(topicAccount, 3, (short) 1);
	}
}

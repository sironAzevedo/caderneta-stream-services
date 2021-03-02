package com.caderneta.client.factory;

import org.springframework.stereotype.Component;

import com.caderneta.client.UserClient;
import com.caderneta.client.factory.fallback.UserClientFallback;

import feign.hystrix.FallbackFactory;

@Component
public class UserFallbackFactory implements FallbackFactory<UserClient> {

	@Override
	public UserClient create(Throwable cause) {
		return new UserClientFallback(cause);
	}
}

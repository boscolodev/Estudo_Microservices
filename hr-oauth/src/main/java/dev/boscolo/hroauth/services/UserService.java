package dev.boscolo.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.boscolo.hroauth.dto.UserDTO;
import dev.boscolo.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public UserDTO findByEmail(String email) {
		UserDTO userDTO = userFeignClient.findByEmail(email).getBody();
		logger.info("EMAIL: "+email);
		return userDTO;
	}

}

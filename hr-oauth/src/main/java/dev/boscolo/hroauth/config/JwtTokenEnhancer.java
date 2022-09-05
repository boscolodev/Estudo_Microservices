package dev.boscolo.hroauth.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import dev.boscolo.hroauth.entities.User;
import dev.boscolo.hroauth.services.UserService;

@Component
public class JwtTokenEnhancer implements TokenEnhancer{

	@Autowired
	private UserService service;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		//Adicionar repository para buscar o elemento
		User user = service.findByEmail(authentication.getName());

		//Criando um map e personalizando o corpo do token
		Map<String, Object> map = new HashMap<>();
		map.put("userId", user.getId());
		map.put("name", user.getName());
		map.put("authorities", user.getRoles());
		
		//Downcast e inserção de dados no token
		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
		token.setAdditionalInformation(map);
		
		return accessToken;
	}

}
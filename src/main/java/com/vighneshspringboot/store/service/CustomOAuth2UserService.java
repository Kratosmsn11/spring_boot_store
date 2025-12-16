package com.vighneshspringboot.store.service;

import com.vighneshspringboot.store.model.User;
import com.vighneshspringboot.store.repository.UserRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Primary
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepo userRepo;

    public CustomOAuth2UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{
        OAuth2User oAuth2User = super.loadUser(userRequest);
        syncUser(oAuth2User);

        return oAuth2User;
    }

    public void syncUser(OAuth2User oAuth2User){
        Map<String, Object> attributes = oAuth2User.getAttributes();

        String keycloakId = (String) attributes.get("sub");
        String email = (String) attributes.get("email");
        String username = (String) attributes.get("preferred_username");

        User user = userRepo.findById(keycloakId)
                .orElse(new User());

        user.setId(keycloakId);
        user.setEmail(email);
        user.setUsername(username);

        userRepo.save(user);
    }
}


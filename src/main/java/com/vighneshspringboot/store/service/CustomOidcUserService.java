package com.vighneshspringboot.store.service;

import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.stereotype.Service;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;

@Service
public class CustomOidcUserService extends OidcUserService {

    private final CustomOAuth2UserService customOAuth2UserService;

    public CustomOidcUserService(CustomOAuth2UserService customOAuth2UserService){
        this.customOAuth2UserService = customOAuth2UserService;
    }

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException{

        OidcUser oidcUser = super.loadUser(userRequest);

        customOAuth2UserService.syncUser(oidcUser);

        return oidcUser;
    }
}

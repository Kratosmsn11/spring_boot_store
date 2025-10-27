package com.vighneshspringboot.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/home")
    public String home(Authentication authentication, Model model){
        if(authentication instanceof OAuth2AuthenticationToken){
            OidcUser oidcUser = (OidcUser) authentication.getPrincipal();
            String name = oidcUser.getFullName();
            model.addAttribute("username",name);
        }
        return "home";
    }

//    private String getViewName(){
//        System.out.println("appName : " + appName);
//        return "home";
//    }

    @RequestMapping("/admin")
    public String keycloakAdmin(){
        return "Keycloak Admin";
    }
}
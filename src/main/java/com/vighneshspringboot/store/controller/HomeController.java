package com.vighneshspringboot.store.controller;

import com.vighneshspringboot.store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Value("${app.version}")
    private String appVersion;

    private final CategoryService categoryService;

    @Autowired
    public HomeController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/")
    public String index(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/home";
        }
        return "index";
    }

    @RequestMapping("/home")
    public String home(Authentication authentication, Model model){
        if(authentication instanceof OAuth2AuthenticationToken){
            OidcUser oidcUser = (OidcUser) authentication.getPrincipal();
            String name = oidcUser.getFullName();
            model.addAttribute("username",name);
        }

        model.addAttribute("version", appVersion);
        model.addAttribute("categories", categoryService.getAllCategories());

        return "home";
    }

    @RequestMapping("/admin")
    public String keycloakAdmin(){
        return "Keycloak Admin";
    }
}
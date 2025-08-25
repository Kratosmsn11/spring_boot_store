package com.vighneshspringboot.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping
    public String index(){
        String viewname = getViewName();
        return viewname;
    }

    private String getViewName(){
        return "index.html";
    }
}
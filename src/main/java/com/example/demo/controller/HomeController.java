package com.example.demo.controller;

import com.example.demo.api.ItemApi;
import com.example.demo.api.MerchandiseApi;
import com.example.demo.api.UserApi;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    ItemApi itemApi;

    @Autowired
    UserApi userApi;

    @GetMapping("/")
    public String home(HttpSession httpSession, Model model){
        userApi.setModelFromLoginUserSession(httpSession,model);
        model.addAttribute("item", itemApi.findAll());
        return "/index";
    }
    @GetMapping("/login")
    public String login(){
        return "/user/login";
    }
    @GetMapping("/signup")
    public String signUp(){
        return "/user/signup";
    }
}

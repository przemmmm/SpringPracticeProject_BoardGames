package com.example.springpracticeproject_boardgames.controller;

import com.example.springpracticeproject_boardgames.config.CartSessionConfig;
import com.example.springpracticeproject_boardgames.service.UserService;
import com.example.springpracticeproject_boardgames.session.UserSession;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;
//
@Controller
public class SessionDemoController {
//
//    private UserService service;
//
//    @Resource(name="cartSession")
//    //
//    private CartSessionConfig cartSessionConfig;
//
//    public SessionDemoController(UserService service) {
//        this.service = service;
//    }

//    @GetMapping("/session-info")
//    public String getSessionInfo(HttpSession session, Model model) {
//        if (userSession.emailIsEmpty()) {
//            userSession.setUserEmail("test - " + new Random().nextInt());
//        }
//
//        if (session.getAttribute("message") == null) {
//            session.setAttribute("message","test - " + new Random().nextInt());
//        }
//
//        model.addAttribute("sessionMessage",   session.getAttribute("message"));
//        model.addAttribute("userSession",   userSession);
//
//        return "session-info";
//    }

}



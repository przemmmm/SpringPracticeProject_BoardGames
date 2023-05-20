package com.example.springpracticeproject_boardgames.controller;

import com.example.springpracticeproject_boardgames.dto.LoginDTO;
import com.example.springpracticeproject_boardgames.dto.RegisterDTO;
import com.example.springpracticeproject_boardgames.exception.AuthenticationServiceException;
import com.example.springpracticeproject_boardgames.service.CustomerService;
import lombok.Getter;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {
    private CustomerService customerService;

    public AuthenticationController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage(){
        RegisterDTO registerDTO = new RegisterDTO();
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("registerDTO", registerDTO);
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView createCustomer (@ModelAttribute("registerDTO") RegisterDTO registerDTO){
        ModelAndView modelAndView = new ModelAndView("index.html");
        customerService.createCustomer(registerDTO);
        return modelAndView;
    }

    @GetMapping("/login")
    public String getLoginPage (Model model){
        LoginDTO loginDTO = new LoginDTO();
        model.addAttribute("loginDTO", loginDTO );
        return "login";
    }

    @PostMapping("/login")
    public String login (@ModelAttribute ("loginDTO") LoginDTO loginDTO, Model model){
        try{
            customerService.loginCustomer(loginDTO);
            model.addAttribute("message", "You are logged in");
        }catch (AuthenticationServiceException e){
            model.addAttribute("message", e.getMessage());
        }
        return "index";
    }
}

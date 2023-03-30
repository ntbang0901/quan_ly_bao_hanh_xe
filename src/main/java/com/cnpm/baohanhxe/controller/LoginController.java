package com.cnpm.baohanhxe.controller;

import com.cnpm.baohanhxe.model.TaiKhoanDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private HttpSession session;

    @Autowired
    private MessageSource messageSource;


    @GetMapping("/login")
    public String login(ModelMap model, HttpServletRequest request){
        model.addAttribute("account",new TaiKhoanDto());
        String message = messageSource.getMessage("hello", null, "default message", request.getLocale());
        model.addAttribute("message", message);
        return "login";
    }
}

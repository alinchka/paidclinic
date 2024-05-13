package com.paidclinic.controller;

import com.paidclinic.entity.UserDTO;
import com.paidclinic.service.EntryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EntryController
{
    @Autowired
    EntryService entryService;

    @GetMapping("/")
    public String homePage(Model model) {
        return "home";
    }
    @GetMapping("/register")
    public String regGet(Model model)
    {
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String regPost(@ModelAttribute("user") UserDTO newUser, HttpServletRequest request) throws ServletException
    {
        if (!newUser.getPassword().equals(newUser.getConfirmPassword()))
        {
            return "redirect:/register?error";
        }

        if (entryService.addUser(newUser))
        {
            request.login(newUser.getName(), newUser.getPassword());
            System.out.println("LOL");
            return "redirect:/";
        }

        return "redirect:/register?exists";
    }

    @GetMapping("/login")
    public String loginPage()
    {
        return "login";
    }
}
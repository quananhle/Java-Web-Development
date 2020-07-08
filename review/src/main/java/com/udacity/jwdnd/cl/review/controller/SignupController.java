package com.udacity.jwdnd.cl.review.controller;

import com.udacity.jwdnd.cl.review.model.User;
import com.udacity.jwdnd.cl.review.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignupController {
    private final UserService userService;
    public SignupController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    public String signupView() {
        return "signup";
    }
    @PostMapping()
    public String signupUser(@ModelAttribute User user, Model model) {
        String signupError = null;

        if (userService.isUsernameExisted(user.getUserName())) {
            signupError = "The username is already existed.";
        }
        if (signupError == null) {
            int createRow = userService.createUser(user);
            if (createRow < 0) {
                signupError = "Failed to sign up. Please try again later";
            }
        }
        if (signupError == null) {
            model.addAttribute("signupSuccess", true);
        }
        else {
            model.addAttribute("signupError", signupError);
        }
        return "signup";
    }
}

package com.witon.jakub.ai.user;

import com.witon.jakub.ai.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/sign-up")
    String signUpPage(User user) {

        return "sign-up";
    }

    @PostMapping("/sign-up")
    String signUp(User user) {

        userService.signUpUser(user);
        return "redirect:/";
    }
    @GetMapping("/")
    public String xd() {
        return "redirect:/budget-list";
    }
    @GetMapping("/welcome")
    String zalogowany()
    {
        System.out.println("XD");
        return "redirect:/budget-list";
    }

}

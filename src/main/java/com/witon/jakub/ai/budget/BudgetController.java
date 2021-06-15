package com.witon.jakub.ai.budget;

import com.witon.jakub.ai.entity.User;
import com.witon.jakub.ai.user.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BudgetController {
    private UserRepository userRepository;
    @GetMapping("/budget-list")
    public String listUsers(Model model) {
      //  List<User> users
        return "";
    }
}

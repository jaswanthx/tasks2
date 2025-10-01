package taskmanager.com.tasks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import taskmanager.com.tasks.Service.Userservice;
import taskmanager.com.tasks.model.Users;

@Controller
public class userController {

    @Autowired
    private Userservice userService;

    @GetMapping({"/", "/tasksmanager"})
    public String home() {
        return "/tasksmanager/home";
    }

    @GetMapping("/tasksmanager/signup")
    public String signup(Model model) {
        model.addAttribute("user", new Users());
        return "tasksmanager/signup";
    }

    @PostMapping("/tasksmanager/signup")
    public String add(@ModelAttribute("user") Users user) {
        userService.add(user);
        return "redirect:/tasksmanager/login";
    }

    @GetMapping("/tasksmanager/login")
    public String login(Model model) {
        model.addAttribute("user", new Users());
        return "tasksmanager/login";
    }

    // Login is now handled by Spring Security
    // This method is no longer needed
}

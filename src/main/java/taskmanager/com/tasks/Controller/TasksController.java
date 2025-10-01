package taskmanager.com.tasks.Controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import taskmanager.com.tasks.Service.TasksService;
import taskmanager.com.tasks.config.CustomUserDetails;
import taskmanager.com.tasks.model.Users;
import taskmanager.com.tasks.model.tasks;

@Controller
@RequestMapping("/tasksmanager/tasks")
public class TasksController {

    private final TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping
    public String listTasks(Model model, Authentication authentication) {
        // Fetch tasks of logged-in user
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Users user = userDetails.getUser();
        List<tasks> tasks = tasksService.getTasksByUser(user);
        model.addAttribute("tasks", tasks);
        return "tasksmanager/tasks/list";
    }

    @GetMapping("/create")
    public String createTaskForm(Model model) {
        model.addAttribute("task", new tasks());
        return "tasksmanager/tasks/create";
    }

    @PostMapping("/create")
    public String saveTask(@ModelAttribute("task") tasks task, Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Users user = userDetails.getUser();
        task.setUser(user);
        tasksService.saveTask(task);
        return "redirect:/tasksmanager/tasks";
    }

    @GetMapping("/edit/{id}")
    public String editTaskForm(@PathVariable Long id, Model model) {
        tasks task = tasksService.getTaskById(id);
        model.addAttribute("task", task);
        return "tasksmanager/tasks/edit";
    }

    @PostMapping("/update")
    public String updateTask(@ModelAttribute("task") tasks task, Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Users user = userDetails.getUser();
        task.setUser(user);
        tasksService.saveTask(task);
        return "redirect:/tasksmanager/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        tasksService.deleteTask(id);
        return "redirect:/tasksmanager/tasks";
    }
    
    @GetMapping("/homepage")
    public String homepage(Authentication authentication, Model model) {
        // Optionally fetch tasks or stats to display
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        model.addAttribute("username", userDetails.getUsername());
        return "tasksmanager/tasks/homepage";  // You must create homepage.html
    }

}

package taskmanager.com.tasks.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import taskmanager.com.tasks.Repository.TaskRepositoy;
import taskmanager.com.tasks.model.Users;
import taskmanager.com.tasks.model.tasks;

@Service
public class TasksService {

    private final TaskRepositoy tasksRepository;

    public TasksService(TaskRepositoy tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public tasks saveTask(tasks task) {
        return tasksRepository.save(task);
    }

    public List<tasks> getTasksByUser(Users user) {
        return tasksRepository.findByUser(user);
    }

    public void deleteTask(Long taskId) {
        tasksRepository.deleteById(taskId);
    }

    public tasks getTaskById(Long taskId) {
        return tasksRepository.findById(taskId).orElse(null);
    }
}

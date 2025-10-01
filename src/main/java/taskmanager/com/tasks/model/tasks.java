package taskmanager.com.tasks.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 255)
    private String description;

    @Column(nullable = false, length = 20)
    private String category; // e.g., Work, Personal, Urgent

    @Column(nullable = false, length = 10)
    private String priority; // e.g., Low, Medium, High

    @Column(nullable = false, length = 10)
    private String status; // e.g., Pending, Completed

    @Column(nullable = true)
    private LocalDate dueDate;

    @Column(nullable = false, updatable = false)
    private LocalDateTime creationDate;

    @Column(nullable = true)
    private LocalDateTime updationDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    
    // ===== Lifecycle Callbacks =====
    @PrePersist
    protected void onCreate() {
        this.creationDate = LocalDateTime.now();
        this.status = "Pending"; // default status
    }

    @PreUpdate
    protected void onUpdate() {
        this.updationDate = LocalDateTime.now();
    }
   

	// ===== Constructors =====
    public tasks() {
    }

    // ===== Getters and Setters =====
    
    public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdationDate() {
        return updationDate;
    }

    public void setUpdationDate(LocalDateTime updationDate) {
        this.updationDate = updationDate;
    }

}

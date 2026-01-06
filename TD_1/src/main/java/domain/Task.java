package domain;

import java.time.LocalDateTime;

public class Task {
    private final String id;
    private String title;
    private TaskStatus status;
    private final LocalDateTime createdAt;

    public Task(String id, String title, TaskStatus status, LocalDateTime createdAt) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Le titre de la tâche ne peut pas être vide.");
        }
        this.id = id;
        this.title = title;
        this.status = (status != null) ? status : TaskStatus.TODO;
        this.createdAt = (createdAt != null) ? createdAt : LocalDateTime.now();
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public TaskStatus getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Le titre ne peut pas être vide.");
        }
        this.title = title;
    }

    public void setStatus(TaskStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Le statut ne peut pas être null.");
        }
        this.status = status;
    }
}
package domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class TaskBuilder {
    private String id;
    private String title;
    private TaskStatus status;
    private LocalDateTime createdAt;

    public TaskBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public TaskBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public TaskBuilder withStatus(TaskStatus status) {
        this.status = status;
        return this;
    }

    public TaskBuilder createdNow() {
        this.createdAt = LocalDateTime.now();
        return this;
    }

    public Task build() {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Le titre de la tâche ne peut pas être vide.");
        }
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
        if (status == null) {
            status = TaskStatus.TODO;
        }
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        return new Task(id, title, status, createdAt);
    }
}
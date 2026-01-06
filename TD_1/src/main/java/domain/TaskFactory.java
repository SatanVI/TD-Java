package domain;

import java.util.UUID;
import java.time.LocalDateTime;

public class TaskFactory {


    public static Task createTodo(String title) {
        return new TaskBuilder()
                .withId(UUID.randomUUID().toString())
                .withTitle(title)
                .withStatus(TaskStatus.TODO)
                .createdNow()
                .build();
    }


    public static Task createInProgress(String title) {
        return new TaskBuilder()
                .withId(UUID.randomUUID().toString())
                .withTitle(title)
                .withStatus(TaskStatus.IN_PROGRESS)
                .createdNow()
                .build();
    }
}
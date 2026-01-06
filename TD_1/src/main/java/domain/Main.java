package domain;

import config.AppConfig;

public class Main {
    public static void main(String[] args) {
        Task task = new TaskBuilder()
                .withTitle("Learn Builder pattern")
                .createdNow()
                .build();

        System.out.println("Task créée : " + task.getTitle() + " [" + task.getStatus() + "]");


        Task t1 = TaskFactory.createTodo("Setup project");
        Task t2 = TaskFactory.createInProgress("Implement repository");

        System.out.println("Tâche 1 : " + t1.getTitle() + " [" + t1.getStatus() + "]");
        System.out.println("Tâche 2 : " + t2.getTitle() + " [" + t2.getStatus() + "]");

        AppConfig config = AppConfig.getInstance();

        System.out.println("Application: " + config.getAppName());
        System.out.println("Environnement: " + config.getEnvironment());
        System.out.println("Port: " + config.getPort());
        System.out.println("Storage mode: " + config.getStorageMode());
    }
}
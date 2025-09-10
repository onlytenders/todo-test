package com.practice.backend.task;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository tasks;

    public TaskService(TaskRepository tasks) {
        this.tasks = tasks;
    }

    public Integer add(Task task) {
        tasks.save(task);
        return task.getId();
    }

    public Task delete(Integer id) {
        Task task = tasks.findById(id).orElse(new Task());
        tasks.delete(task);
        return task;
    }

    public List<Task> get() {
        return tasks.findAll();
    }

    public Task update(Task task) {
        return tasks.save(task);
    }

}

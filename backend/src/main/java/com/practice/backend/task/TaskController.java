package com.practice.backend.task;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/tasks")
public class TaskController {

    TaskService taskService = new TaskService();

    @GetMapping("/")
    public List<Task> getTasks() {
        return taskService.get();
    }

    @PutMapping("addTask")
    public Integer addTask(String name, String description) {
        return taskService.add(new Task(name, description));
    }

    @DeleteMapping("/removeTask/{id}")
    public Task removeTask(@PathVariable Integer id) {
        return taskService.delete(id);
    }

    @PatchMapping("/editTask")
    public Task editTask(@RequestBody Task task) {
        return taskService.update(task);
    }

}

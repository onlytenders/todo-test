package com.practice.backend.task;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.get();
    }

    @PostMapping
    public Integer addTask(String name, String description) {
        return taskService.add(new Task(name, description));
    }

    @DeleteMapping("/{id}")
    public Task removeTask(@PathVariable Integer id) {
        return taskService.delete(id);
    }

    @PatchMapping
    public Task editTask(@RequestBody Task task) {
        return taskService.update(task);
    }

}

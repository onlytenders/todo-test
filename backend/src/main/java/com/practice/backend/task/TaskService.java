package com.practice.backend.task;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    List<Task> tasks = new ArrayList<>();

    public Integer add(Task task) {
        task.setId(tasks.size());

        tasks.add(task);
        return task.getId();
    }

    public Task delete(Integer id) {
        Task task = tasks.get(id);
        tasks.remove(task);
        return task;
    }

    public List<Task> get() {
        return tasks;
    }

    public Task update(Task task) {
        return tasks.set(task.getId(), task);
    }

}

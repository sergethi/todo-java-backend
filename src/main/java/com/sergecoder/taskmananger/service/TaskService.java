package com.sergecoder.taskmananger.service;

import com.sergecoder.taskmananger.model.Task;

import java.util.List;

public interface TaskService {
    public Task saveTask(Task task);
    public List<Task> getAllTasks();
    public Task getOne(Integer id);
    public void deleteOne(Integer id);
}

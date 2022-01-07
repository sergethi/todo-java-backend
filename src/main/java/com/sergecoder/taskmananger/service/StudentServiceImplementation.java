package com.sergecoder.taskmananger.service;

import com.sergecoder.taskmananger.model.Task;
import com.sergecoder.taskmananger.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentServiceImplementation implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }


    public Task getOne(Integer id) {
        return taskRepository.findById(id).get();
    }

    public void deleteOne(Integer id) {
       taskRepository.deleteById(id);
    }
}

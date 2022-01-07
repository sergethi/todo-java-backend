package com.sergecoder.taskmananger.controller;

import com.sergecoder.taskmananger.model.Task;
import com.sergecoder.taskmananger.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public  String add(@RequestBody Task task){
        taskService.saveTask(task);
        return "New task is added!!";
    }

    @GetMapping("/getTasks")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> get(@PathVariable Integer id){
        try {
            Task task = taskService.getOne(id);
            return new ResponseEntity<Task>(task, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@RequestBody Task task, @PathVariable Integer id){
        try {
            Task existingTask = taskService.getOne(id);
            existingTask.setId(task.getId());
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            taskService.saveTask(task);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
    }
//    @PutMapping("/employees/{id}")
//    public ResponseEntity < Employee > updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
//        Employee employee = employeeRepository.findById(id)
//                .orElseThrow(() - > new ResourceNotFoundException("Employee not exist with id :" + id));
//
//        employee.setFirstName(employeeDetails.getFirstName());
//        employee.setLastName(employeeDetails.getLastName());
//        employee.setEmailId(employeeDetails.getEmailId());
//
//        Employee updatedEmployee = employeeRepository.save(employee);
//        return ResponseEntity.ok(updatedEmployee);
//    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        taskService.deleteOne(id);
        return "Deleted tasks with id " + id;
    }
}

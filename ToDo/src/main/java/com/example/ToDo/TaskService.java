package com.example.ToDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> listAll(){
        return taskRepository.findAll();
    }

    public void save(Task task){
        taskRepository.save(task);
    }

    public Task get(long id){
        return taskRepository.findById(id).get();
    }

    public void delete(long id){
        taskRepository.deleteById(id);
    }
}

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
        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(dt);
        taskRepository.save(task);



        task.setCreateDate(currentTime);
        task.setUpdateDate(currentTime);

        System.out.print(task.getUpdateDate());
    }

    public Task get(long id){
        return taskRepository.findById(id).get();
    }

    public void delete(long id){
        taskRepository.deleteById(id);
    }
}

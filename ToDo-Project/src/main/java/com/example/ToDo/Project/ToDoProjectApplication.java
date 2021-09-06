package com.example.ToDo.Project;

import com.example.ToDo.Project.task.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ToDoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoProjectApplication.class, args);
	}

}

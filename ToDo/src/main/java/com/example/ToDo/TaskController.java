package com.example.ToDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        List<Task> listTask = taskService.listAll();
        model.addAttribute("listTask",listTask);
        System.out.print("viewHomePage Running..... ");
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model){
        model.addAttribute("task",new Task());
        return "new";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveTask(@ModelAttribute("task") Task task){
        taskService.save(task);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditTaskPage(@PathVariable(name = "id") int id){
        ModelAndView modelAndView = new ModelAndView("new");
        Task task = taskService.get(id);
        modelAndView.addObject("task",task);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteTask(@PathVariable(name = "id") int id){
        taskService.delete(id);
        return "redirect:/";
    }
}

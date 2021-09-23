package com.example.ToDo.Task;

import com.example.ToDo.User.User;
import com.example.ToDo.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView= new ModelAndView("Login");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute("user") User user){
        User logUser = userService.login(user.getUsername(), user.getPassword());
        if(Objects.nonNull(logUser)){
            return "redirect:/";
        }else {
            return "redirect:/login";
        }
    }

    @RequestMapping("/logout")
    public String logoutDo(HttpServletRequest request, HttpServletResponse response)
    {
        return "redirect:/login";
    }

    @GetMapping("/")
    public String viewHomePage(Model model){
        List<Task> listTask = taskService.listAll();
        model.addAttribute("listTask",listTask);
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model){
        model.addAttribute("task",new Task());
        return "new";
    }

    @GetMapping("/details/{id}")
    public String showDetailsTaskPage(@PathVariable(name = "id") int id,Model model){
        Task task = taskService.get(id);
        model.addAttribute("task",task);
        return "details";
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

    @RequestMapping("/back")
    public String backToHomePage(){
        return "redirect:/";
    }
}

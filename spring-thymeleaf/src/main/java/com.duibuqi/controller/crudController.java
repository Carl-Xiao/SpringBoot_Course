package com.duibuqi.controller;

import com.duibuqi.bean.User;
import com.duibuqi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class crudController {
    @RequestMapping(value = "")
    public String index() {
        return "main";
    }

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public String userList(Model model){
        model.addAttribute("users",userService.userList());
        return "list";
    }
    @RequestMapping("/del")
    public String deleteUser(Integer id){
        userService.delete(id);
        return "redirect:/list";
    }

    @RequestMapping("/add")
    public String addUser(ModelMap map){
        map.addAttribute("user",new User());
        return "add";
    }

    @RequestMapping("/update/{id}")
    public String updateUser(@PathVariable Integer id, ModelMap map){
        map.addAttribute("user", userService.getById(id));
        return "update";
    }

    @RequestMapping("/saveI")
    public String saveI(@ModelAttribute User user){
        userService.insert(user);
        return "redirect:/list";
    }

    @RequestMapping("/saveU")
    public String saveU(@ModelAttribute User user){
        userService.update(user);
        return "redirect:/list";
    }

}

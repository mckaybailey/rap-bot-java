package org.launchcode.controllers;


import org.launchcode.models.forms.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private org.launchcode.models.data.UserDao userDao;

    @RequestMapping(value="register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title","register");

        return "login/register";
    }
    @RequestMapping(value="register", method = RequestMethod.POST)
    public String registerdb(@ModelAttribute @Valid User newUser,
                             Errors errors, @RequestParam String email, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Register");
            model.addAttribute(new User());
            model.addAttribute("email", email);
            return "login/register";
        }
        try {
            userDao.save(newUser);
        } catch (Exception e){
            return "redirect:";
        }
        return "redirect:";

    }
    @RequestMapping(value="", method = RequestMethod.POST)
    public String logindb(@ModelAttribute @Valid User logUser,
                          Errors errors,Model model) {
        String enteredem = logUser.getEmail();
        String enteredpw = logUser.getPassword();
        List<User> users = (List<User>) userDao.findAll();
        String password = "";
        int owner_id = 0;
        for(User ind : users){
            if(ind.getEmail().equals(enteredem)){
                password = ind.getPassword();
                owner_id = ind.getId();
            }

        }
        if(password.equals(enteredpw)){
            return "redirect:in?id="+owner_id;
        }


        model.addAttribute(new User());
        model.addAttribute("title", "login");
        return "login/login";
    }
    @RequestMapping(value="", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title", "login");
        return "login/login";
    }

    @RequestMapping(value="error", method = RequestMethod.GET)
    public String error(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title","register");

        return "login/login";
    }

}

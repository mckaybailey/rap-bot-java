package org.launchcode.controllers;

import org.launchcode.models.forms.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("error")
public class ErrorController {

    @RequestMapping(value="error", method = RequestMethod.GET)
    public String error(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title","register");

        return "login/login";
        }
    @RequestMapping(value="", method = RequestMethod.POST)
    public String errorp(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title","register");

        return "login/login";
    }
}

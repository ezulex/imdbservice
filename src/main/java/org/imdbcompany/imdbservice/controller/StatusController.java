package org.imdbcompany.imdbservice.controller;

import org.imdbcompany.imdbservice.model.Status;
import org.imdbcompany.imdbservice.model.User;
import org.imdbcompany.imdbservice.service.StatusService;
import org.imdbcompany.imdbservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StatusController {

    @Autowired
    private StatusService statusService;

    //display list of users
    @GetMapping("/statuses")
    public String viewHomePage(Model model){
        model.addAttribute("listStatuses", statusService.getAllStatuses());
        return "statuses";
    }

    @GetMapping("/statuses/showNewStatusForm")
    public String showNewStatusForm(Model model) {
        Status status = new Status();
        model.addAttribute("status", status);
        return "new_status";
    }

    @PostMapping("/statuses/saveStatus")
    public String saveStatus(@ModelAttribute("status") Status status) {
        statusService.saveStatus(status);
        return "redirect:/statuses";
    }

    @GetMapping("/statuses/showFormForUpdateStatus/{id}")
    public String showFormForUpdateStatus(@PathVariable(value = "id") long id, Model model) {
        Status status = statusService.getStatusById(id);
        model.addAttribute("status", status);
        return "update_status";
    }

    @GetMapping("/statuses/deleteStatus/{id}")
    public String deleteStatus(@PathVariable(value = "id") long id) {
        this.statusService.deleteStatusById(id);
        return "redirect:/statuses";
    }
}

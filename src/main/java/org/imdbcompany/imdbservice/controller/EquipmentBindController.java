package org.imdbcompany.imdbservice.controller;

import org.imdbcompany.imdbservice.model.EquipmentBind;
import org.imdbcompany.imdbservice.service.EquipmentBindService;
import org.imdbcompany.imdbservice.service.EquipmentService;
import org.imdbcompany.imdbservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EquipmentBindController {

    @Autowired
    private EquipmentBindService equipmentBindService;
    @Autowired
    private UserService userService;
    @Autowired
    private EquipmentService equipmentService;

    //display list of users
    @GetMapping("/equipment_binds")
    public String viewHomePage(Model model){
        model.addAttribute("listEquipmentBind", equipmentBindService.getAllEquipmentBinds());
        return "equipment_binds";
    }

    @GetMapping("/equipment_binds/showNewEquipmentBindForm")
    public String showNewEquipmentBindForm(Model model) {
        EquipmentBind equipmentBind = new EquipmentBind();
        model.addAttribute("equipment_bind", equipmentBind);
        model.addAttribute("listUsers", userService.getAllUsers());
        model.addAttribute("listEquipments", equipmentService.getAllEquipments());


        return "new_equipment_bind";
    }

    @PostMapping("/equipment_binds/saveEquipmentBind")
    public String saveEquipmentBind(@ModelAttribute("equipment_bind") EquipmentBind equipmentBind) {
        equipmentBindService.saveEquipmentBind(equipmentBind);
        return "redirect:/equipment_binds";
    }

    @GetMapping("/equipment_binds/showFormForUpdateEquipmentBind/{id}")
    public String showFormForUpdateEquipmentBind(@PathVariable(value = "id") long id, Model model) {
        EquipmentBind equipmentBind = equipmentBindService.getEquipmentBindById(id);
        model.addAttribute("equipment_bind", equipmentBind);
        model.addAttribute("listUsers", userService.getAllUsers());
        model.addAttribute("listEquipments", equipmentService.getAllEquipments());
        return "update_equipment_bind";
    }

    @GetMapping("/equipment_binds/deleteEquipmentBind/{id}")
    public String deleteEquipmentBind(@PathVariable(value = "id") long id) {
        this.equipmentBindService.deleteEquipmentBindById(id);
        return "redirect:/equipment_binds";
    }
}

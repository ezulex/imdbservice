package org.imdbcompany.imdbservice.controller;

import org.imdbcompany.imdbservice.model.Equipment;
import org.imdbcompany.imdbservice.model.Status;
import org.imdbcompany.imdbservice.service.EquipmentService;
import org.imdbcompany.imdbservice.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private StatusService statusService;

    //display list of users
    @GetMapping("/equipments")
    public String viewHomePage(Model model){
        model.addAttribute("listEquipments", equipmentService.getAllEquipments());
        return "equipments";
    }

    @GetMapping("/equipments/showNewEquipmentForm")
    public String showNewEquipmentForm(Model model) {
        Equipment equipment = new Equipment();
        model.addAttribute("equipment", equipment);
        model.addAttribute("listStatuses", statusService.getAllStatuses());
        return "new_equipment";
    }

    @PostMapping("/equipments/saveEquipment")
    public String saveEquipment(@ModelAttribute("equipment") Equipment equipment) {
        equipmentService.saveEquipment(equipment);
        return "redirect:/equipments";
    }

    @GetMapping("/equipments/showFormForUpdateEquipment/{id}")
    public String showFormForUpdateEquipment(@PathVariable(value = "id") long id, Model model) {
        Equipment equipment = equipmentService.getEquipmentById(id);
        model.addAttribute("equipment", equipment);
        model.addAttribute("listStatuses", statusService.getAllStatuses());
        return "update_equipment";
    }

    @GetMapping("/equipments/deleteEquipment/{id}")
    public String deleteEquipment(@PathVariable(value = "id") long id) {
        this.equipmentService.deleteEquipmentById(id);
        return "redirect:/equipments";
    }
}

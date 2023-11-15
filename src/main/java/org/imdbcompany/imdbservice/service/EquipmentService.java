package org.imdbcompany.imdbservice.service;

import org.imdbcompany.imdbservice.model.Equipment;

import java.util.List;

public interface EquipmentService {
    List<Equipment> getAllEquipments();
    void saveEquipment(Equipment equipment);
    Equipment getEquipmentById(long id);
    void deleteEquipmentById(long id);
}

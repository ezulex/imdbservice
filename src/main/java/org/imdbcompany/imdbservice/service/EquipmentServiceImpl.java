package org.imdbcompany.imdbservice.service;

import org.imdbcompany.imdbservice.model.Equipment;
import org.imdbcompany.imdbservice.model.Status;
import org.imdbcompany.imdbservice.repository.EquipmentRepository;
import org.imdbcompany.imdbservice.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService{
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Override
    public List<Equipment> getAllEquipments() {
        return equipmentRepository.findAll();
    }

    @Override
    public void saveEquipment(Equipment equipment) {
        this.equipmentRepository.save(equipment);
    }

    @Override
    public Equipment getEquipmentById(long id) {
        Optional<Equipment> optional = equipmentRepository.findById(id);
        Equipment equipment = null;
        if (optional.isPresent()) {
            equipment = optional.get();
        } else {
            throw new RuntimeException("Equipment not found for id: " + id);
        }
        return equipment;
    }

    @Override
    public void deleteEquipmentById(long id) {
        this.equipmentRepository.deleteById(id);
    }
}

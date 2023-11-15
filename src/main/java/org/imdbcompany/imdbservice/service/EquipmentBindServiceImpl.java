package org.imdbcompany.imdbservice.service;

import org.imdbcompany.imdbservice.model.EquipmentBind;
import org.imdbcompany.imdbservice.repository.EquipmentBindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentBindServiceImpl implements EquipmentBindService{
    @Autowired
    private EquipmentBindRepository equipmentBindRepository;
    @Override
    public List<EquipmentBind> getAllEquipmentBinds() {
        return equipmentBindRepository.findAll();
    }

    @Override
    public void saveEquipmentBind(EquipmentBind equipmentBind) {
        try {
            this.equipmentBindRepository.save(equipmentBind);
        } catch (Exception ex) {
            System.out.println(ex.getCause().getMessage());
        }
    }

    @Override
    public EquipmentBind getEquipmentBindById(long id) {
        Optional<EquipmentBind> optional = equipmentBindRepository.findById(id);
        EquipmentBind equipmentBind = null;
        if (optional.isPresent()) {
            equipmentBind = optional.get();
        } else {
            throw new RuntimeException("EquipmentBind not found for id: " + id);
        }
        return equipmentBind;
    }

    @Override
    public void deleteEquipmentBindById(long id) {
        this.equipmentBindRepository.deleteById(id);
    }
}

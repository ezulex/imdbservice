package org.imdbcompany.imdbservice.service;

import org.imdbcompany.imdbservice.model.EquipmentBind;
import org.imdbcompany.imdbservice.model.User;

import java.util.List;

public interface EquipmentBindService {
    List<EquipmentBind> getAllEquipmentBinds();
    void saveEquipmentBind(EquipmentBind equipmentBind);
    EquipmentBind getEquipmentBindById(long id);
    void deleteEquipmentBindById(long id);
}

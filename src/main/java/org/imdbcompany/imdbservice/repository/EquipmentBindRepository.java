package org.imdbcompany.imdbservice.repository;

import org.imdbcompany.imdbservice.model.EquipmentBind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentBindRepository extends JpaRepository<EquipmentBind, Long> {
}

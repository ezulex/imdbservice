package org.imdbcompany.imdbservice.service;

import org.imdbcompany.imdbservice.model.Equipment;
import org.imdbcompany.imdbservice.model.Status;
import org.imdbcompany.imdbservice.repository.EquipmentRepository;
import org.imdbcompany.imdbservice.repository.StatusRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
public class EquipmentServiceImplTest {

    @Mock
    private EquipmentRepository equipmentRepository;
    @InjectMocks
    private EquipmentServiceImpl equipmentService;

    @Test
    public void shouldReturnEquipmentById() {
        List<Equipment> equipments = getEquipments();
        Long id = 1L;

        Mockito.when(equipmentRepository.findById(eq(1L))).thenReturn(Optional.of(equipments.get(0)));
        Equipment result = equipmentService.getEquipmentById(id);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(equipments.get(0), result);
    }

    @Test
    public void shouldReturnAllEquipments() {
        List<Equipment> equipments = getEquipments();

        Mockito.when(equipmentRepository.findAll()).thenReturn(equipments);
        List<Equipment> result = equipmentService.getAllEquipments();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(equipments, result);
    }

    @Test
    public void shouldUpdateEquipment() {
        List<Equipment> equipments = getEquipments();
        Long id = 1L;

        Equipment newEquipment = equipments.get(0);
        newEquipment.setType("Монитор");

        equipmentService.saveEquipment(newEquipment);

        Assertions.assertEquals(equipments.get(0).getType(), newEquipment.getType());
    }

    private List<Equipment> getEquipments() {
        Equipment firstEquipment = new Equipment();
        Equipment secondEquipment = new Equipment();
        Status status = new Status();

        status.setId(1L);
        status.setName("В закупке");

        firstEquipment.setId(1L);
        firstEquipment.setBrand("Asus");
        firstEquipment.setModel("110");
        firstEquipment.setAmortizationPeriod(36L);
        firstEquipment.setPurchaseCost(120000L);
        firstEquipment.setType("Ноутбук");
        firstEquipment.setPurchaseDate(LocalDate.ofEpochDay(2023-01-01));
        firstEquipment.setSerialNumber("GGGHHH");
        firstEquipment.setStatus(status);

        secondEquipment.setId(2L);
        secondEquipment.setBrand("HP");
        secondEquipment.setModel("Pro");
        secondEquipment.setAmortizationPeriod(24L);
        secondEquipment.setPurchaseCost(150000L);
        secondEquipment.setType("Ноутбук");
        secondEquipment.setPurchaseDate(LocalDate.ofEpochDay(2022-12-20));
        secondEquipment.setSerialNumber("FFFFF");
        secondEquipment.setStatus(status);

        return List.of(firstEquipment, secondEquipment);
    }
}

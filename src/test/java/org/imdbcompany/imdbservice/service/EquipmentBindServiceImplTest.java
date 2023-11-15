package org.imdbcompany.imdbservice.service;

import org.imdbcompany.imdbservice.model.Equipment;
import org.imdbcompany.imdbservice.model.EquipmentBind;
import org.imdbcompany.imdbservice.model.Status;
import org.imdbcompany.imdbservice.model.User;
import org.imdbcompany.imdbservice.repository.EquipmentBindRepository;
import org.imdbcompany.imdbservice.repository.EquipmentRepository;
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
public class EquipmentBindServiceImplTest {

    @Mock
    private EquipmentBindRepository equipmentBindRepository;
    @InjectMocks
    private EquipmentBindServiceImpl equipmentBindService;

    @Test
    public void shouldReturnEquipmentBindById() {
        List<EquipmentBind> equipments = getEquipmentBinds();
        Long id = 1L;

        Mockito.when(equipmentBindRepository.findById(eq(1L))).thenReturn(Optional.of(equipments.get(0)));
        EquipmentBind result = equipmentBindService.getEquipmentBindById(id);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(equipments.get(0), result);
    }

    @Test
    public void shouldReturnAllEquipmentBinds() {
        List<EquipmentBind> equipments = getEquipmentBinds();

        Mockito.when(equipmentBindRepository.findAll()).thenReturn(equipments);
        List<EquipmentBind> result = equipmentBindService.getAllEquipmentBinds();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(equipments, result);
    }

    @Test
    public void shouldUpdateEquipmentBind() {
        List<EquipmentBind> equipments = getEquipmentBinds();
        Long id = 1L;

        EquipmentBind newEquipmentBind = equipments.get(0);
        newEquipmentBind.setIssueDate(LocalDate.ofEpochDay(2000-01-01));

        equipmentBindService.saveEquipmentBind(newEquipmentBind);

        Assertions.assertEquals(equipments.get(0).getIssueDate(), newEquipmentBind.getIssueDate());
    }

    private List<EquipmentBind> getEquipmentBinds() {
        EquipmentBind firstEquipmentBind = new EquipmentBind();
        EquipmentBind secondEquipmentBind = new EquipmentBind();

        User firstUser = new User();
        Status status = new Status();
        Equipment firstEquipment = new Equipment();

        firstUser.setId(1L);
        firstUser.setName("Вася");
        firstUser.setLastName("Пупкин");
        firstUser.setDepartment("Закупки");
        firstUser.setPosition("Руководитель");

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

        firstEquipmentBind.setId(1L);
        firstEquipmentBind.setUser(firstUser);
        firstEquipmentBind.setEquipment(firstEquipment);
        firstEquipmentBind.setIssueDate(LocalDate.ofEpochDay(2023-01-01));

        secondEquipmentBind.setId(2L);
        secondEquipmentBind.setUser(firstUser);
        secondEquipmentBind.setEquipment(firstEquipment);
        secondEquipmentBind.setIssueDate(LocalDate.ofEpochDay(2022-01-01));



        return List.of(firstEquipmentBind, secondEquipmentBind);
    }
}

package org.imdbcompany.imdbservice.service;

import org.imdbcompany.imdbservice.model.Status;
import org.imdbcompany.imdbservice.model.User;
import org.imdbcompany.imdbservice.repository.StatusRepository;
import org.imdbcompany.imdbservice.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
public class StatusServiceImplTest {

    @Mock
    private StatusRepository statusRepository;
    @InjectMocks
    private StatusServiceImpl statusService;

    @Test
    public void shouldReturnStatusById() {
        List<Status> statuses = getStatuses();
        Long id = 1L;

        Mockito.when(statusRepository.findById(eq(1L))).thenReturn(Optional.of(statuses.get(0)));
        Status result = statusService.getStatusById(id);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(statuses.get(0), result);
    }

    @Test
    public void shouldReturnAllStatuses() {
        List<Status> statuses = getStatuses();

        Mockito.when(statusRepository.findAll()).thenReturn(statuses);
        List<Status> result = statusService.getAllStatuses();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(statuses, result);
    }

    @Test
    public void shouldUpdateStatus() {
        List<Status> statuses = getStatuses();
        Long id = 1L;

        Status newStatus = statuses.get(0);
        newStatus.setName("Тестовое");

        statusService.saveStatus(newStatus);

        Assertions.assertEquals(statuses.get(0).getName(), newStatus.getName());
    }

    private List<Status> getStatuses() {
        Status firstStatus = new Status();
        Status secondStatus = new Status();

        firstStatus.setId(1L);
        firstStatus.setName("Новый");

        secondStatus.setId(2L);
        secondStatus.setName("В закупке");

        return List.of(firstStatus, secondStatus);
    }
}

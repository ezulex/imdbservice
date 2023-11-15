package org.imdbcompany.imdbservice.service;

import org.imdbcompany.imdbservice.model.User;
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
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void shouldReturnUserById() {
        List<User> users = getUsers();
        Long id = 1L;

        Mockito.when(userRepository.findById(eq(1L))).thenReturn(Optional.of(users.get(0)));
        User result = userService.getUserById(id);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(users.get(0), result);
    }

    @Test
    public void shouldReturnAllUsers() {
        List<User> users = getUsers();

        Mockito.when(userRepository.findAll()).thenReturn(users);
        List<User> result = userService.getAllUsers();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(users, result);
    }

    @Test
    public void shouldUpdateUser() {
        List<User> users = getUsers();
        Long id = 1L;

        User newUser = users.get(0);
        newUser.setLastName("Новая");

        userService.saveUser(newUser);

        Assertions.assertEquals(users.get(0).getLastName(), newUser.getLastName());
    }

//    @Test
//    public void shouldDeleteUserById() {
//        List<User> users = getUsers();
//        Long id = 1L;
//
//
//        userService.deleteUserById(id);
//
//        Assertions.assertNull(users.get(0));
//    }

    private List<User> getUsers() {
        User firstUser = new User();
        User secondUser = new User();

        firstUser.setId(1L);
        firstUser.setName("Вася");
        firstUser.setLastName("Пупкин");
        firstUser.setDepartment("Закупки");
        firstUser.setPosition("Руководитель");

        secondUser.setId(2L);
        secondUser.setName("Петя");
        secondUser.setLastName("Иванов");
        secondUser.setDepartment("Продажи");
        secondUser.setPosition("Специалист");

        return List.of(firstUser, secondUser);
    }
}

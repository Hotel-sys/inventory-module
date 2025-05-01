package app.controllers.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.extension.ExtendWith;

import app.controllers.UserController;
import app.entities.User;
import app.services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService; // Mock do serviço

    @InjectMocks
    private UserController userController; // Injeção dos mocks no controller

    @Test
    @DisplayName("Teste de integração - create")
    void create() {
        User user = new User();
        when(userService.save(user)).thenReturn(user);

        ResponseEntity<User> response = userController.create(user);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    @DisplayName("Teste de integração - getById")
    void getById() {
        String id = "1";
        User user = new User();
        when(userService.findById(id)).thenReturn(user);

        ResponseEntity<User> response = userController.getById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    @DisplayName("Teste de integração - getAll")
    void getAll() {
        List<User> users = Arrays.asList(new User(), new User());
        when(userService.findAll()).thenReturn(users);

        ResponseEntity<List<User>> response = userController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(users, response.getBody());
    }

    @Test
    @DisplayName("Teste de integração - update")
    void update() {
        String id = "1";
        User user = new User();
        when(userService.update(id, user)).thenReturn(user);

        ResponseEntity<User> response = userController.update(id, user);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    @DisplayName("Teste de integração - delete")
    void delete() {
        String id = "1";
        doNothing().when(userService).delete(id);

        ResponseEntity<Void> response = userController.delete(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
    @Test
    @DisplayName("Teste unitário - greeting")
    void greeting() {
        
        ResponseEntity<String> response = userController.greeting();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Hello, welcome to the User API!", response.getBody());
    }
}

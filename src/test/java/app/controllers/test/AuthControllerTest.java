package app.controllers.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.controllers.AuthController;
import app.dtos.LoginRequest;
import app.services.AuthService;

import org.mockito.InjectMocks;
import org.mockito.Mock;

@SpringBootTest
public class AuthControllerTest {

    @Mock
    AuthService authService;

    @InjectMocks
    AuthController authController;

    @Test
    @DisplayName("Teste de integração - logout com sucesso")
    void logoutSuccess() {
        when(authService.logout()).thenReturn(true);

        ResponseEntity<Void> response = authController.logout();

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    @DisplayName("Teste de integração - logout com falha")
    void logoutFailure() {
        when(authService.logout()).thenReturn(false);

        ResponseEntity<Void> response = authController.logout();

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(null, response.getBody());
    }
}

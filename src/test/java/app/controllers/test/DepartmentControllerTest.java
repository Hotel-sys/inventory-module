package app.controllers.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import app.controllers.DepartmentController;
import app.entities.Department;
import app.services.DepartmentService;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DepartmentControllerTest {

    @Mock
    private DepartmentService departmentService;

    @InjectMocks
    private DepartmentController departmentController;

    @Test
    @DisplayName("Teste de integração - create")
    void create() {
        Department department = new Department();
        when(departmentService.save(department)).thenReturn(department);

        ResponseEntity<Department> response = departmentController.create(department);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(department, response.getBody());
    }

    @Test
    @DisplayName("Teste de integração - getById")
    void getById() {
        String id = "1";
        Department department = new Department();
        when(departmentService.findById(id)).thenReturn(department);

        ResponseEntity<Department> response = departmentController.getById(id);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(department, response.getBody());
    }

    @Test
    @DisplayName("Teste de integração - getAll")
    void getAll() {
        List<Department> departments = Arrays.asList(new Department(), new Department());
        when(departmentService.findAll()).thenReturn(departments);

        ResponseEntity<List<Department>> response = departmentController.getAll();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(departments, response.getBody());
    }

    @Test
    @DisplayName("Teste de integração - update")
    void update() {
        String id = "1";
        Department department = new Department();
        when(departmentService.update(id, department)).thenReturn(department);

        ResponseEntity<Department> response = departmentController.update(id, department);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(department, response.getBody());
    }

    @Test
    @DisplayName("Teste de integração - delete")
    void delete() {
        String id = "1";
        doNothing().when(departmentService).delete(id);

        ResponseEntity<Void> response = departmentController.delete(id);

        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("Teste de integração - findByNameStartingWith")
    void findByNameStartingWith() {
        String name = "Dept";
        List<Department> departments = Arrays.asList(new Department(), new Department());
        when(departmentService.findByNameStartingWith(name)).thenReturn(departments);

        ResponseEntity<Department> response = departmentController.findByNameStartingWith(name);

        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("Teste de integração - findByDescriptionContaining")
    void findByDescriptionContaining() {
        String address = "New York";
        List<Department> departments = Arrays.asList(new Department(), new Department());
        when(departmentService.findByDescriptionContaining(address)).thenReturn(departments);

        ResponseEntity<Department> response = departmentController.findByDescriptionContaining(address);

        assertEquals(200, response.getStatusCodeValue());
    }
}

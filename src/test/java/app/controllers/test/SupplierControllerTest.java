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

import app.controllers.SupplierController;
import app.entities.Supplier;
import app.services.SupplierService;

@ExtendWith(MockitoExtension.class) 
public class SupplierControllerTest {

    @Mock
    private SupplierService supplierService; 

    @InjectMocks
    private SupplierController supplierController; 

    @Test
    @DisplayName("Teste de integração - create")
    void create() {
        Supplier supplier = new Supplier();
        when(supplierService.save(supplier)).thenReturn(supplier);

        ResponseEntity<Supplier> response = supplierController.create(supplier);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(supplier, response.getBody());
    }

    @Test
    @DisplayName("Teste de integração - getById")
    void getById() {
        String id = "1";
        Supplier supplier = new Supplier();
        when(supplierService.findById(id)).thenReturn(supplier);

        ResponseEntity<Supplier> response = supplierController.getById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(supplier, response.getBody());
    }

    @Test
    @DisplayName("Teste de integração - getAll")
    void getAll() {
        List<Supplier> suppliers = Arrays.asList(new Supplier(), new Supplier());
        when(supplierService.findAll()).thenReturn(suppliers);

        ResponseEntity<List<Supplier>> response = supplierController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(suppliers, response.getBody());
    }

    @Test
    @DisplayName("Teste de integração - update")
    void update() {
        String id = "1";
        Supplier supplier = new Supplier();
        when(supplierService.update(id, supplier)).thenReturn(supplier);

        ResponseEntity<Supplier> response = supplierController.update(id, supplier);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(supplier, response.getBody());
    }

    @Test
    @DisplayName("Teste de integração - delete")
    void delete() {
        String id = "1";
        doNothing().when(supplierService).delete(id);

        ResponseEntity<Void> response = supplierController.delete(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

}

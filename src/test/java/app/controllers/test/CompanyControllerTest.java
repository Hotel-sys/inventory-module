package app.controllers.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import app.controllers.CompanyController;
import app.entities.Company;
import app.services.CompanyService;

@SpringBootTest
public class CompanyControllerTest {

    @Mock
    private CompanyService companyService;

    @InjectMocks
    private CompanyController companyController;

    @Test
    @DisplayName("Teste de integração - create")
    void create() {
        Company company = new Company();
        when(companyService.save(company)).thenReturn(company);

        ResponseEntity<Company> response = companyController.create(company);

        assertEquals(company, response.getBody());
    }

    @Test
    @DisplayName("Teste de integração - getById")
    void getById() {
        String id = "1";
        Company company = new Company();
        when(companyService.findById(id)).thenReturn(company);

        ResponseEntity<Company> response = companyController.getById(id);

        assertEquals(company, response.getBody());
    }

    @Test
    @DisplayName("Teste de integração - getAll")
    void getAll() {
        List<Company> companies = new ArrayList<>();
        companies.add(new Company());
        companies.add(new Company());

        when(companyService.findAll()).thenReturn(companies);

        ResponseEntity<List<Company>> response = companyController.getAll();

        assertEquals(companies, response.getBody());
    }

    @Test
    @DisplayName("Teste de integração - update")
    void update() {
        String id = "1";
        Company company = new Company();

        when(companyService.update(id, company)).thenReturn(company);

        ResponseEntity<Company> response = companyController.update(id, company);

        assertEquals(company, response.getBody());
    }

    @Test
    @DisplayName("Teste de integração - delete")
    void delete() {
        String id = "1";

        doNothing().when(companyService).delete(id);

        ResponseEntity<Void> response = companyController.delete(id);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(null, response.getBody());
    }
    
    @Test
    @DisplayName("Teste de integração - findByNameStartingWith")
    void findByNameStartingWith() {
        String name = "Tech";
        List<Company> companies = new ArrayList<>();
        companies.add(new Company());
        companies.add(new Company());

        when(companyService.findByNameStartingWith(name)).thenReturn(companies);

        ResponseEntity<List<Company>> response = companyController.findByNameStartingWith(name);

        assertEquals(companies, response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("Teste de integração - findByAddressContaining")
    void findByAddressContaining() {
        String address = "Street";
        List<Company> companies = new ArrayList<>();
        companies.add(new Company());

        when(companyService.findByAddressContaining(address)).thenReturn(companies);

        ResponseEntity<List<Company>> response = companyController.findByAddressContaining(address);

        assertEquals(companies, response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }
}

package app.controllers.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.controllers.CategoryController;
import app.entities.Category;
import app.repositories.CategoryRepository;
import app.services.CategoryService;

@SpringBootTest
public class CategoryControllerTest {
	
	@Mock
    CategoryService categoryService;

    @InjectMocks
    CategoryController categoryController;
	
    @Test
    @DisplayName("Teste de integração - create")
    void create() {
        Category category = new Category();

        when(categoryService.save(category)).thenReturn(category);

        ResponseEntity<Category> response = categoryController.create(category);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(category, response.getBody());
    }
	
    @Test
    @DisplayName("Teste de integração - getById (quando não encontrado)")
    void getByIdNotFound() {
    	String id = "1";

    	when(categoryService.findById(id)).thenThrow(new RuntimeException("Categoria não encontrada"));

    	assertThrows(RuntimeException.class, () -> {
    		categoryController.getById(id);
    	});
    }

	
	@Test
	@DisplayName("Teste de integração - getAll")
	void getAll() {
		List<Category> list = new ArrayList<>();
		
		Category category1 =  new Category();
		Category category2 =  new Category();
		
		list.add(category1);
		list.add(category2);
		
		when(categoryService.findAll()).thenReturn(list);
		
		ResponseEntity<List<Category>> response = categoryController.getAll();
		
		assertEquals(list, response.getBody());
	}
	
	@Test
	@DisplayName("Teste de integração - update")
	void update() {
	    String id = "1";
	    Category category = new Category();

	    when(categoryService.update(id, category)).thenReturn(category);

	    ResponseEntity<Category> response = categoryController.update(id, category);

	    assertEquals(category, response.getBody());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("Teste de integração - delete")
	void delete() {
	    String id = "1";
	    
	    doNothing().when(categoryService).delete(id);

	    ResponseEntity<Void> response = categoryController.delete(id);
	   
	    assertEquals(204, response.getStatusCodeValue());
	    assertEquals(null, response.getBody());
	}
}

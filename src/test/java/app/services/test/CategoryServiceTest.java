package app.services.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import app.entities.Category;
import app.repositories.CategoryRepository;
import app.services.CategoryService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Teste de integraçao - Deve salvar uma categoria usando o mock do repositório")
    void save() {
        Category category = new Category();

        when(categoryRepository.save(category)).thenReturn(category);

        Category result = categoryService.save(category);

        assertEquals(category, result);
        
    }
    
    @Test
    @DisplayName("Teste de integração - saveAll")
    void saveAll() {
    	List<Category> list = new ArrayList();
    	
    	Category category1 =  new Category();
    	Category category2 =  new Category();
    	
    	list.add(category1);
    	list.add(category2);
    	
    	when(categoryRepository.saveAll(list)).thenReturn(list);
    	
    	List<Category> response = categoryService.saveAll(list);
    	
    	assertEquals(list, response);
    	
    }
}

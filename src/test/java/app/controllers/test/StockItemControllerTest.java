package app.controllers.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.controllers.StockItemController;
import app.entities.StockItem;
import app.services.StockItemService;

@ExtendWith(MockitoExtension.class)
public class StockItemControllerTest {

    @Mock
    private StockItemService stockItemService;

    @InjectMocks
    private StockItemController stockItemController;

    @Test
    @DisplayName("Teste de integração - create")
    void create() {
        StockItem stockItem = new StockItem();
        when(stockItemService.save(stockItem)).thenReturn(stockItem);

        ResponseEntity<StockItem> response = stockItemController.create(stockItem);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stockItem, response.getBody());
    }

    @Test
    @DisplayName("Teste de integração - getById")
    void getById() {
        String id = "1";
        StockItem stockItem = new StockItem();
        when(stockItemService.findById(id)).thenReturn(stockItem);

        ResponseEntity<StockItem> response = stockItemController.getById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stockItem, response.getBody());
    }

    @Test
    @DisplayName("Teste de integração - getAll")
    void getAll() {
        List<StockItem> stockItems = Arrays.asList(new StockItem(), new StockItem());
        when(stockItemService.findAll()).thenReturn(stockItems);

        ResponseEntity<List<StockItem>> response = stockItemController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stockItems, response.getBody());
    }

    @Test
    @DisplayName("Teste de integração - update")
    void update() {
        String id = "1";
        StockItem stockItem = new StockItem();
        when(stockItemService.update(id, stockItem)).thenReturn(stockItem);

        ResponseEntity<StockItem> response = stockItemController.update(id, stockItem);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(stockItem, response.getBody());
    }

    @Test
    @DisplayName("Teste de integração - delete")
    void delete() {
        String id = "1";
        doNothing().when(stockItemService).delete(id);

        ResponseEntity<Void> response = stockItemController.delete(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}

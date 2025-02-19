package app.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IController<T, ID> {

    /**
     * Creates a new entity.
     * @param entity The entity to create.
     * @return ResponseEntity with the created entity.
     */
    ResponseEntity<T> create(@RequestBody T entity);

    /**
     * Retrieves an entity by its ID.
     * @param id The ID of the entity.
     * @return ResponseEntity with the entity if found.
     */
    ResponseEntity<T> getById(@PathVariable ID id);

    /**
     * Retrieves all entities.
     * @return ResponseEntity with the list of all entities.
     */
    ResponseEntity<List<T>> getAll();

    /**
     * Retrieves a paginated list of entities.
     * @param page The page number (zero-based index).
     * @param size The number of items per page.
     * @return ResponseEntity with the paginated list of entities.
     */
    ResponseEntity<List<T>> getAll(@RequestParam(defaultValue = "0") int page, 
                                   @RequestParam(defaultValue = "10") int size);

    /**
     * Updates an existing entity.
     * @param id The ID of the entity to update.
     * @param entity The updated entity.
     * @return ResponseEntity with the updated entity.
     */
    ResponseEntity<T> update(@PathVariable ID id, @RequestBody T entity);

    /**
     * Deletes an entity by its ID.
     * @param id The ID of the entity to delete.
     * @return ResponseEntity with a success message.
     */
    ResponseEntity<Void> delete(@PathVariable ID id);

    /**
     * Deletes multiple entities by their IDs.
     * @param ids A list of IDs to delete.
     * @return ResponseEntity with a success message.
     */
    ResponseEntity<Void> deleteAll(@RequestBody List<ID> ids);
}

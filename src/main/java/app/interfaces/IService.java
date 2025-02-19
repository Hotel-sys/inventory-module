package app.interfaces;

import java.util.List;
import java.util.Optional;

public interface IService<T, ID> {
	/**
     * Saves a new entity or updates an existing one.
     * @param entity The entity to save or update.
     * @return The persisted entity.
     */
    T save(T entity);

    /**
     * Saves multiple entities in a batch.
     * @param entities The list of entities to save.
     * @return The list of saved entities.
     */
    List<T> saveAll(List<T> entities);

    /**
     * Finds an entity by its ID.
     * @param id The ID of the entity.
     * @return An Optional containing the entity if found, or empty otherwise.
     */
    T findById(ID id);

    /**
     * Retrieves all entities.
     * @return A list of all entities.
     */
    List<T> findAll();

    /**
     * Retrieves entities with pagination.
     * @param page The page number (zero-based index).
     * @param size The number of items per page.
     * @return A paginated list of entities.
     */
    List<T> findAll(int page, int size);

    /**
     * Checks if an entity exists by its ID.
     * @param id The ID to check.
     * @return true if the entity exists, false otherwise.
     */
    boolean existsById(ID id);

    /**
     * Updates an existing entity.
     * @param id The ID of the entity to update.
     * @param entity The entity with updated data.
     * @return The updated entity.
     */
    T update(ID id, T entity);

    /**
     * Deletes an entity by its ID.
     * @param id The ID of the entity to delete.
     */
    void delete(ID id);

    /**
     * Deletes multiple entities by their IDs.
     * @param ids A list of IDs to delete.
     */
    void deleteAll(List<ID> ids);

    /**
     * Deletes all entities.
     */
    void deleteAll();
}

package app.interfaces;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generic Mapper Interface for converting between Entity and DTO.
 */
public interface IMapper<E, D> {

    D toDto(E entity);
    
    E toEntity(D dto);

    default List<D> toDtoList(List<E> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default List<E> toEntityList(List<D> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}

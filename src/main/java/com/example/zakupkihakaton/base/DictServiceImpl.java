package com.example.zakupkihakaton.base;

import com.example.zakupkihakaton.exception.CustomError;
import com.example.zakupkihakaton.exception.CustomException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public abstract class DictServiceImpl<
        Entity, Index,
        Repository extends JpaRepository<Entity, Index>,
        Response, Request,
        Mapper extends DictMapper<Entity, Response, Request>> {

    protected abstract Repository getRepository();

    protected abstract Logger getLog();

    protected abstract Mapper getMapper();

    public List<Response> getList() {
        List<Entity> entities = getRepository().findAll();
        return entities.stream()
                .map(getMapper()::toResponse)
                .collect(Collectors.toList());
    }

    public Page<Response> getAll(int page, int size) {
        Page<Entity> entities = getRepository().findAll(PageRequest.of(page, size));
        return entities.map(getMapper()::toResponse);
    }

    public Response getById(Index id) {
        Optional<Entity> entity = getRepository().findById(id);
        if (entity.isPresent()) {
            return getMapper().toResponse(entity.get());
        } else {
            throw new CustomException(CustomError.ENTITY_NOT_FOUND, getLog());
        }
    }

    public Response create(@NonNull Request request) {
        Entity entity = getMapper().toEntity(request);
        Entity savedEntity = getRepository().save(entity);
        return getMapper().toResponse(savedEntity);
    }

    @Transactional
    public Response update(Index id, @NonNull Request request) {
        if (getRepository().existsById(id)) {
            Entity entity = getRepository().getById(id);
            getMapper().update(entity, request);

            Entity updatedEntity = getRepository().save(entity);
            return getMapper().toResponse(updatedEntity);
        } else {
            throw new CustomException(CustomError.ENTITY_NOT_FOUND, getLog());
        }
    }

    public void delete(Index id) {
        if (getRepository().existsById(id)) {
            getRepository().deleteById(id);
        } else {
            throw new CustomException(CustomError.ENTITY_NOT_FOUND, getLog());
        }
    }
}

package com.example.zakupkihakaton.base;

import org.mapstruct.MappingTarget;

public interface DictMapper<Entity, Response, Request> {
    Response toResponse(Entity entity);

    Entity toEntity(Request request);

    void update(@MappingTarget Entity entity, Request request);
}

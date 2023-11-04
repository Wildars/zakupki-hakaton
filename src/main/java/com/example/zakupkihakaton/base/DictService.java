package com.example.zakupkihakaton.base;

import org.springframework.data.domain.Page;

import java.util.List;

public interface DictService<Index, Response, Request> {
    List<Response> getList();

    Page<Response> getAll(int page, int size);

    Response getById(Index id);

    Response create(Request request);

    Response update(Index id, Request request);

    void delete(Index id);
}
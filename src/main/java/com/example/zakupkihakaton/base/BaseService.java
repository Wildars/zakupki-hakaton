package com.example.zakupkihakaton.base;

import org.springframework.data.domain.Page;

import java.util.List;

public interface BaseService<Index, Element, Response, Request> {
    List<Element> findList();

    Page<Element> findAll(int page, int size);

    Response findById(Index id);

    Response create(Request request);

    Response update(Index id, Request request);

    void delete(Index id);
}
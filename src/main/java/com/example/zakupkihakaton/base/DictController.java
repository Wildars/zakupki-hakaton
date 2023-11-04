package com.example.zakupkihakaton.base;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class DictController<Index, Response, Request,
        Service extends DictService<Index, Response, Request>> {

    protected abstract Service getService();

    @GetMapping("/list")
    public List<Response> getList() {
        return getService().getList();
    }

    @GetMapping("/all")
    public Page<Response> getAll(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "25") int size) {
        return getService().getAll(page, size);
    }

    @GetMapping("/{id}")
    public Response getById(@PathVariable Index id) {
        return getService().getById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Response create(@Valid @RequestBody Request request) {
        return getService().create(request);
    }

    @PutMapping("/{id}")
    public Response create(@PathVariable Index id, @Valid @RequestBody Request request) {
        return getService().update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Index id) {
        getService().delete(id);
    }
}

package com.example.zakupkihakaton.service;

import com.example.zakupkihakaton.model.response.PermissionCategoryResponse;
import com.example.zakupkihakaton.model.request.RoleRequest;
import com.example.zakupkihakaton.model.response.RoleResponse;


import java.util.List;

public interface RoleService {
    RoleResponse create(RoleRequest request);

    RoleResponse update(RoleRequest request, Short id);

    RoleResponse findById(Short id);

    List<RoleResponse> findAll();

    List<PermissionCategoryResponse> getPermissions();

    Boolean delete(Short id);
}
